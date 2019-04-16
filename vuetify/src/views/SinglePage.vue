<template>
  <v-container>
    <v-layout row>
      <v-flex xs12 text-xs-center>
        <v-alert type="warning" v-model="alert" dismissible>{{message}}</v-alert>
        <v-alert type="success" v-model="success" dismissible>{{message}}</v-alert>
        <v-btn v-on:click="getGlobalStats" small color="info">Get Global Statistics</v-btn>
      </v-flex>
    </v-layout>
    <v-layout row>
      <v-flex xs3><v-text-field placeholder="User Id" v-model.number="statsIdUser" type="number"></v-text-field></v-flex>
      <v-flex xs3 pt-2><v-btn v-on:click="fetchUserStats" small color="info">Get User Statistics</v-btn></v-flex>
      <v-flex xs3><v-text-field placeholder="URL Id" v-model.number="statsIdUrl" type="number"></v-text-field></v-flex>
      <v-flex xs3 pt-2><v-btn v-on:click="fetchUrlStats" small color="info">Get URL Statistics</v-btn></v-flex>
    </v-layout>
    <v-layout row>
      <v-flex xs3><v-text-field placeholder="User name" v-model.trim="username"></v-text-field></v-flex>
      <v-flex xs3 pt-2><v-btn v-on:click="insertUser" small color="info">Add User</v-btn></v-flex>
      <v-flex xs2><v-text-field placeholder="User Id" v-model.number="idUserHyperlink" type="number"></v-text-field></v-flex>
      <v-flex xs2><v-text-field placeholder="Hperlink" v-model.trim="hyperlink"></v-text-field></v-flex>
      <v-flex xs2 pt-2><v-btn v-on:click="insertUrl" small color="info">Add URL</v-btn></v-flex>
    </v-layout>
    <v-layout row>
      <v-flex xs3><v-text-field placeholder="User Id" v-model.number="deleteIdUser" type="number"></v-text-field></v-flex>
      <v-flex xs3 pt-2><v-btn v-on:click="removeUser" small color="info">Delete User</v-btn></v-flex>
      <v-flex xs3><v-text-field placeholder="URL Id" v-model.number="deleteIdUrl" type="number"></v-text-field></v-flex>
      <v-flex xs3 pt-2><v-btn v-on:click="removeUrl" small color="info">Delete URL</v-btn></v-flex>
    </v-layout>
    <v-layout row v-show="globalStatsVisible">
      <v-flex xs6>Hits: {{statsDto.hits}}</v-flex>
      <v-flex xs6>URL Count: {{statsDto.urlCount}}</v-flex>
    </v-layout>
    <v-layout row v-show="urlStatsVisible">
      <v-data-table :headers="headers" :items="urlStatsDto" style="width: 100%">
        <template v-slot:items="urls">
          <td>{{urls.item.id}}</td>
          <td>{{urls.item.hits}}</td>
          <td>{{urls.item.url}}</td>
          <td>{{urls.item.shortUrl}}</td>
        </template>
      </v-data-table>
    </v-layout>
  </v-container>
</template>

<script>
  import { mapState, mapActions } from 'vuex'

  export default {
    name: 'SinglePage',
    computed: {
      ...mapState(['globalStatsVisible', 'urlStatsVisible', 'userRecordVisible', 'statsDto', 'urlStatsDto', 'userDto', 'headers']),
      alert : {
        get () { return this.$store.state.alert },
        set (value) { this.$store.commit('setAlert', value) }
      },
      success : {
        get () { return this.$store.state.success },
        set (value) { this.$store.commit('setSuccess', value) }
      },
      message : {
        get () { return this.$store.state.message },
        set (value) { this.$store.commit('setMessage', value) }
      },
      statsIdUser : {
        get () { return this.$store.state.statsIdUser },
        set (value) { this.$store.commit('setStatsIdUser', value) }
      },
      statsIdUrl : {
        get () { return this.$store.state.statsIdUrl },
        set (value) { this.$store.commit('setStatsIdUrl', value) }
      },
      username : {
        get () { return this.$store.state.username },
        set (value) { this.$store.commit('setUsername', value) }
      },
      idUserHyperlink : {
        get () { return this.$store.state.idUserHyperlink },
        set (value) { this.$store.commit('setIdUserHyperlink', value) }
      },
      hyperlink : {
        get () { return this.$store.state.hyperlink },
        set (value) { this.$store.commit('setHyperlink', value) }
      },
      deleteIdUser : {
        get () { return this.$store.state.deleteIdUser },
        set (value) { this.$store.commit('setDeleteIdUser', value) }
      },
      deleteIdUrl : {
        get () { return this.$store.state.deleteIdUrl },
        set (value) { this.$store.commit('setDeleteIdUrl', value) }
      }
    },
    methods: {
      vazio: function(obj) {
        return obj === undefined || obj === null;
      },

      fetchUserStats: function() {
        if (this.statsIdUser === null || isNaN(this.statsIdUser) || this.statsIdUser <= 0) {
          this.message = "Invalid User Id!";
          this.alert = true;
        } else {
          this.$store.dispatch('getUserStats');
        }
      },

      fetchUrlStats: function() {
        if (this.statsIdUrl === null || isNaN(this.statsIdUrl) || this.statsIdUrl <= 0) {
          this.message = "Invalid URL Id!";
          this.alert = true;
        } else {
          this.$store.dispatch('getUrlStats');
        }
      },

      insertUser: function() {
        if (this.username === null || this.username.length === 0) {
          this.message = "Invalid User Name!";
          this.alert = true;
        } else {
          this.$store.dispatch('addUser');
        }
      },

      insertUrl: function() {
        if (this.idUserHyperlink === null || isNaN(this.idUserHyperlink) || this.idUserHyperlink <= 0) {
          this.message = "Invalid User Id!";
          this.alert = true;
        } else if (this.hyperlink === null || this.hyperlink.length === 0) {
          this.message = "Invalid Hyperlink!";
          this.alert = true;
        } else {
          this.$store.dispatch('addUrl');
        }
      },

      removeUser: function() {
        if (this.deleteIdUser === null || isNaN(this.deleteIdUser) || this.deleteIdUser <= 0) {
          this.message = "Invalid User Id!";
          this.alert = true;
        } else {
          this.$store.dispatch('deleteUser');
        }
      },

      removeUrl: function() {
        if (this.deleteIdUrl === null || isNaN(this.deleteIdUrl) || this.deleteIdUrl <= 0) {
          this.message = "Invalid URL Id!";
          this.alert = true;
        } else {
          this.$store.dispatch('deleteUrl');
        }
      },

      ...mapActions(['getGlobalStats', 'getUserStats', 'getUrlStats', 'addUser', 'addUrl', 'deleteUser', 'deleteUrl'])
    },
    created () {
      this.getGlobalStats()
    }
  }
</script>

<style>

</style>
