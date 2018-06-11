var app = angular.module('urlShrinkerApp', []);

app.controller('urlShrinkerCtrl', function($scope, $http, $location) {
	var url = "http://" + $location.$$host + ":" + $location.$$port + "/urlShrinkerAngularJS";

	$scope.globalStatsVisible = false;
	$scope.urlStatsVisible = false;

	$scope.statsBean = {};
	$scope.urlStatsBean;

	$scope.hideAll = function() {
		$scope.globalStatsVisible = false;
		$scope.urlStatsVisible = false;
		$scope.userRecordVisible = false;
	}

	$scope.getGlobalStats = function() {
		$scope.hideAll();

		$http.get(url + "/globalStats").then(function(response) {
			$scope.statsBean = response.data;
			$scope.globalStatsVisible = true;

			$scope.urlStatsBean = $scope.statsBean.topUrls;
			$scope.urlStatsVisible = true;
		});
	}

	$scope.statsIdUser = "";

	$scope.getUserStats = function() {
		$scope.hideAll();

		if ($scope.statsIdUser.trim().length == 0 || isNaN($scope.statsIdUser)) {
			alert("Invalid User Id!");
		} else {
			$http.get(url + "/userStats/" + $scope.statsIdUser).then(function(response) {
				$scope.urlStatsBean = response.data;
				$scope.urlStatsVisible = true;
			});
		}
	}

	$scope.statsIdUrl = "";

	$scope.getUrlStats = function() {
		$scope.hideAll();

		if ($scope.statsIdUrl.trim().length == 0 || isNaN($scope.statsIdUrl)) {
			alert("Invalid URL Id!");
		} else {
			$http.get(url + "/urlStats/" + $scope.statsIdUrl).then(function(response) {
				$scope.urlStatsBean = [response.data];
				$scope.urlStatsVisible = true;
			});
		}
	}

	$scope.userRecordVisible = false;
	$scope.username = "";
	$scope.userBean;

	$scope.addUser = function() {
		$scope.hideAll();

		if ($scope.username.trim().length == 0) {
			alert("Invalid User Name!");
		} else {
			var userBean = {"userName": $scope.username};

			$http.post(url + "/addUser", userBean).then(function(response) {
				if (response.status == 201) {
					$scope.userBean = response.data;
					$scope.userRecordVisible = true;
				} else if (response.status == 204) {
					alert("The user [username=" + $scope.username + "] already exists!");
				}
			});
		}
	}

	$scope.idUserHyperlink = "";
	$scope.hyperlink = "";

	$scope.addUrl = function() {
		$scope.hideAll();

		if ($scope.idUserHyperlink.trim().length == 0 || isNaN($scope.idUserHyperlink)) {
			alert("Invalid User Id!");
		} else if ($scope.hyperlink.trim().length == 0) {
			alert("Invalid Hyperlink!");
		} else {
			var urlBean = {"url" : $scope.hyperlink};

			$http.post(url + "/addUrl/" + $scope.idUserHyperlink, urlBean).then(function(response) {
				if (response.status == 201) {
					$scope.urlStatsBean = response.data;
					$scope.urlStatsVisible = true;
				} else if (response.status == 204) {
					alert("The user [id=" + $scope.idUserHyperlink + "] has not been found!");
				}
			});
		}
	}

	$scope.deleteIdUser = "";

	$scope.deleteUser = function() {
		$scope.hideAll();

		if ($scope.deleteIdUser.trim().length == 0 || isNaN($scope.deleteIdUser)) {
			alert("Invalid User Id!");
		} else {
			$http.delete(url + "/deleteUser/" + $scope.deleteIdUser).then(function(response) {
				alert(response.data);
			});
		}
	}

	$scope.deleteIdUrl = "";

	$scope.deleteUrl = function() {
		$scope.hideAll();

		if ($scope.deleteIdUrl.trim().length == 0 || isNaN($scope.deleteIdUrl)) {
			alert("Invalid URL Id!");
		} else {
			$http.delete(url + "/deleteUrl/" + $scope.deleteIdUrl).then(function(response) {
				alert(response.data);
			});
		}
	}

});
