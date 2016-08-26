angular.module('icm-app').controller("loginCtrl", function($scope, $http) {
	
	$scope.loginSocial = function (socialType) {
		console.log(socialType);
		var url = "http://localhost:8080/connect/"+socialType
		$http.get(url).then(function (response) {
			console.log("Success");
		}, function (errorResponse) {
			console.log("Failed");
		});
	};
});