var module = angular.module('icm-app', ['ui.router', 'ui.bootstrap', 'ngDialog']);

//ROOT SCOPE ELEMENTS
module.run(function($rootScope) {
	$rootScope.successBoxFlag = false;
    $rootScope.errorBoxFlag = false;
    $rootScope.panelMessage = "";
	
	$rootScope.autoHide = function() {
	    $rootScope.successBoxFlag = false;
	    $rootScope.errorBoxFlag = false;
	    $rootScope.panelMessage = "";
	};
});

//STATE ROUTES
module.config(function ($stateProvider, $urlRouterProvider, $provide) {
	$stateProvider.state('icm',
		{
			url: "/login",
			views: {
				'header' : {
					templateUrl : 'pages/logo.html'
				},
				'alert' : {
					templateUrl : 'pages/alert.html',
					controller : 'alertCtrl'
				},
				'content' : {
					templateUrl : 'pages/login.html',
					controller : 'loginCtrl'
				},
				'footer' : {
					templateUrl : 'pages/footer.html'
				}
			}
		}
	);
	$urlRouterProvider.otherwise("/login");
});