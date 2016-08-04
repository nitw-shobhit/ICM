angular.module('icm-app').controller("alertCtrl", function($scope, $rootScope) {

	$scope.closePanel = function() {
		$rootScope.successBoxFlag = false;
		$rootScope.errorBoxFlag = false;
		$rootScope.panelMessage = "";
	};
});