angular.module('icm-app').controller("loginCtrl", function($scope, $http) {
	
	$scope.loginSocial = function (socialType) {
		var url = "http://localhost:8080/signin/"+socialType
		$http.post(url).then(function (response) {
			console.log("Success");
		}, function (errorResponse) {
			console.log("Failed");
		});
	};
});