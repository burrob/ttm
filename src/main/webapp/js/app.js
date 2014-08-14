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

    }).when("/catalogue", {
        templateUrl : "partials/catalogue.html",
        controller : "CatalogueCtrl"

    /*
     * admin ui: players
     */
    }).when("/admin/player/create", {
        templateUrl : "partials/admin/createplayer.html",
        controller : "CreatePlayerCtrl"

    }).when("/admin/player/update/:playerId", {
        templateUrl : "partials/admin/updateplayer.html",
        controller : "UpdatePlayerCtrl"

    /*
     * admin ui: violations and categories
     */
    }).when("/admin/violation/category/create", {
        templateUrl : "partials/admin/createcategory.html",
        controller : "CreateViolationCategoryCtrl"

    }).when("/admin/violation/create", {
        templateUrl : "partials/admin/createviolation.html",
        controller : "CreateViolationCtrl"

    /*
     * default
     */
    }).otherwise({
        redirectTo : "/dashboard"
    });

} ]);