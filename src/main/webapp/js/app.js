var fcoTMApp = angular.module("fcoTM", [ "ngRoute", "fcoTMControllers" ]);

fcoTMApp.config([ "$routeProvider", function($routeProvider) {

    /*
     * user ui
     */
    $routeProvider.when("/dashboard", {
        templateUrl : "partials/dashboard.html",
        controller : "DashboardCtrl"

    }).when("/players", {
        templateUrl : "partials/players.html",
        controller : "PlayersCtrl"

    }).when("/players/:playerId", {
        templateUrl : "partials/player.html",
        controller : "PlayerCtrl"

    /*
     * admin ui
     */
    }).when("/admin/createplayer", {
        templateUrl : "partials/admin/createplayer.html",
        controller : "CreatePlayerCtrl"

    }).when("/admin/updateplayer/:playerId", {
        templateUrl : "partials/admin/updateplayer.html",
        controller : "UpdatePlayerCtrl"

    /*
     * default
     */
    }).otherwise({
        redirectTo : "/dashboard"
    });

} ]);