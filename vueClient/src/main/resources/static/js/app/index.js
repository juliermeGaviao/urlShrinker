function vazio(obj) {
	return obj === undefined || obj === null;
}

function vazioLen(obj) {
	return vazio(obj) || obj.length === 0;
}

var app = new Vue({
    el: '#app',
    data: {
    	globalStatsVisible: false,
    	urlStatsVisible: false,
    	userRecordVisible: false,
    	url: '/urlShrinkerVue',
    	alerta: null,
    	sucesso: null,
    	statsIdUser: null,
    	username: null,
    	deleteIdUser: null,
    	statsIdUrl: null,
    	idUserHyperlink: null,
    	hyperlink: null,
    	deleteIdUrl: null,
    	statsDto: {},
    	urlStatsDto: [],
    	userDto: {},
    	headers: [
    		{text: 'Id', value: 'id', sortable: true},
    		{text: 'Hits', value: 'hits', sortable: true},
    		{text: 'URL', value: 'url', sortable: true},
    		{text: 'Short URL', value: 'shortUrl', sortable: true}
    	]
    },
    methods: {
    	hideAll: function() {
    		this.alerta = null;
    		this.sucesso = null;
    		this.globalStatsVisible = false;
    		this.urlStatsVisible = false;
    		this.userRecordVisible = false;
    	},

    	getGlobalStats: function() {
    		this.hideAll();

    		axios.get(this.url + "/globalStats").then(response => {
    			this.statsDto = response.data;
    			this.globalStatsVisible = true;

    			this.urlStatsDto = this.statsDto.topUrls;
    			this.urlStatsVisible = true;
    		});
    	},

    	getUserStats: function() {
    		this.hideAll();

    		if (vazioLen(this.statsIdUser) || isNaN(this.statsIdUser)) {
    			this.alerta = "Invalid User Id!";
    		} else {
    			axios.get(this.url + "/userStats/" + this.statsIdUser).then(response => {
    				this.urlStatsVisible = response.data.length > 0;

    				if (this.urlStatsVisible) {
    					this.urlStatsDto = response.data;
    				} else {
    					this.urlStatsDto = [];
    				}
    			});
    		}
    	},

    	getUrlStats: function() {
    		this.hideAll();

    		if (vazioLen(this.statsIdUrl) || isNaN(this.statsIdUrl)) {
    			this.alerta = "Invalid URL Id!";
    		} else {
    			axios.get(this.url + "/urlStats/" + this.statsIdUrl).then(response => {
    				this.urlStatsVisible = !vazio(response.data.id);

    				if (this.urlStatsVisible) {
    					this.urlStatsDto = [response.data];
    				} else {
    					this.urlStatsDto = [];
    				}
    			});
    		}
    	},

    	addUser: function() {
    		this.hideAll();

    		if (vazioLen(this.username)) {
    			this.alerta = "Invalid User Name!";
    		} else {
    			var userDto = {"userName": this.username};

    			axios.post(this.url + "/addUser", userDto).then(response => {
    				if (response.status == 201) {
    					this.userDto = response.data;
    					this.userRecordVisible = true;
    					this.sucesso = "User [" + this.username + "] added successfully!";
    				} else if (response.status == 204) {
    					this.alerta = "The user [username=" + this.username + "] already exists!";
    				}
    			});
    		}
    	},

    	addUrl: function() {
    		this.hideAll();

    		if (vazioLen(this.idUserHyperlink) || isNaN(this.idUserHyperlink)) {
    			this.alerta = "Invalid User Id!";
    		} else if (vazioLen(this.hyperlink)) {
    			this.alerta = "Invalid Hyperlink!";
    		} else {
    			var urlDto = {"url" : this.hyperlink};

    			axios.post(this.url + "/addUrl/" + this.idUserHyperlink, urlDto).then(response => {
    				if (response.status == 201) {
        				this.urlStatsVisible = response.data.length > 0;

        				if (this.urlStatsVisible) {
        					this.urlStatsDto = response.data;
        				} else {
        					this.urlStatsDto = [];
        				}

        				this.sucesso = "URL [" + this.hyperlink + "] added successfully!";
    				} else if (response.status == 204) {
    					this.alerta = "The user [id=" + this.idUserHyperlink + "] has not been found!";
    				}
    			});
    		}
    	},

    	deleteUser: function() {
    		this.hideAll();

    		if (vazioLen(this.deleteIdUser) || isNaN(this.deleteIdUser)) {
    			this.alerta = "Invalid User Id!";
    		} else {
    			axios.delete(this.url + "/deleteUser/" + this.deleteIdUser).then(response => {
    				if (response.status == 200) {
    					this.sucesso = response.data;
    				} else if (response.status == 204) {
    					this.alerta = "User Id hasn't been found!";
    				}
    			});
    		}
    	},

    	deleteUrl: function() {
    		this.hideAll();

    		if (vazioLen(this.deleteIdUrl) || isNaN(this.deleteIdUrl)) {
    			this.alerta = "Invalid URL Id!";
    		} else {
    			axios.delete(this.url + "/deleteUrl/" + this.deleteIdUrl).then(response => {
    				if (response.status == 200) {
    					this.sucesso = response.data;
    				} else if (response.status == 204) {
    					this.alerta = "URL Id hasn't been found!";
    				}
    			});
    		}
    	}
    }
});

app.getGlobalStats();
