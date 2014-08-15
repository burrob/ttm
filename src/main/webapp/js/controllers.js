var fcoTMControllers = angular.module("fcoTMControllers", []);

/*
 * user ui controllers
 */

function NavbarController($scope, $location) {
    $scope.isActive = function(viewLocation) {
        return viewLocation === $location.path();
    };
}

/**
 * controller for partials/dashboard.html
 */
fcoTMControllers.controller("DashboardCtrl", [ "$scope", function($scope) {
    // NOP
} ]);

/**
 * controller for partials/players.html
 */
fcoTMControllers.controller("PlayersCtrl", [ "$scope", "$http", function($scope, $http) {
    $http.get("/data/player/all").success(function(data) {
        $scope.players = data;
    });

    /*
     * delete an existing player
     */
    $scope.remove = function(playerIdToRemove) {
        var playerToRemove = _.find($scope.players, function(player) {
            return player.id == playerIdToRemove;
        });

        $http({
            method : "DELETE",
            url : "/data/admin/player/delete/" + playerToRemove.id

        }).success(function(deletedPlayer) {
            $scope.players = _.without($scope.players, playerToRemove);
            $(".modal-backdrop").hide();
        });
    };

} ]);

/**
 * controller for partials/player.html
 */
fcoTMControllers.controller("PlayerCtrl", [ "$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
    $http.get("/data/player/" + $routeParams.playerId).success(function(data) {
        $scope.player = data;
    });
} ]);

/**
 * controller for partials/catalogue.html
 */
fcoTMControllers.controller("CatalogueCtrl", [ "$scope", "$http", function($scope, $http) {
    $http.get("/data/violation/all").success(function(data) {
        $scope.catalogue = data;
    });
} ]);

/*
 * admin ui controllers : players
 */

/**
 * controller for partials/admin/createplayer.html
 * 
 * create a new player
 */
fcoTMControllers.controller("CreatePlayerCtrl", [ "$scope", "$http", function($scope, $http) {
    $scope.master = {};

    $scope.save = function(player, isHistoryBack) {
        $http.post("/data/admin/player/create", player).success(function(data) {
            $scope.error = null;
            $scope.master = angular.copy(data);
            if (isHistoryBack) {
                history.back();
            }

        }).error(function(data, status, headers, config) {
            $scope.error = data;
        });
    };

} ]);

/**
 * controller for partials/admin/editplayer.html
 * 
 * edit an existing player
 */
fcoTMControllers.controller("UpdatePlayerCtrl", [ "$scope", "$http", "$routeParams",
        function($scope, $http, $routeParams) {
            $scope.master = {};

            $http.get("/data/player/" + $routeParams.playerId).success(function(data) {
                $scope.player = data;
            });

            $scope.update = function(player) {
                $http.put("/data/admin/player/update", player).success(function(data) {
                    $scope.master = angular.copy(data);
                });
            };

        } ]);

/*
 * admin ui controllers : violations & categories
 */

/**
 * controller for partials/admin/createcategory.html
 * 
 * create a violation category
 */
fcoTMControllers.controller("CreateViolationCategoryCtrl", [ "$scope", "$http", function($scope, $http) {
    $scope.master = {};

    $scope.save = function(category) {
        $http.post("/data/admin/violation/category/create", category).success(function(data) {
            $scope.master = angular.copy(data);
        });
    };

} ]);

/**
 * controller for partials/admin/createcurrency.html
 * 
 * create a currency
 */
fcoTMControllers.controller("CreateCurrencyCtrl", [ "$scope", "$http", function($scope, $http) {
    $scope.master = {};

    $scope.save = function(currency) {
        $http.post("/data/admin/violation/currency/create", currency).success(function(data) {
            $scope.master = angular.copy(data);
        });
    };

} ]);

/**
 * controller for partials/admin/createviolation.html
 * 
 * create a violation for the catalogue
 */
fcoTMControllers.controller("CreateViolationCtrl", [ "$scope", "$http", function($scope, $http) {
    $scope.master = {};
    $scope.categories = {};
    $scope.currencies = {};

    $http.get("/data/admin/violation/category/all").success(function(data) {
        $scope.categories = data;
    });

    $http.get("/data/admin/violation/currency/all").success(function(data) {
        $scope.currencies = data;
    });

    $scope.save = function(violation) {
        $http.post("/data/admin/violation/create", violation).success(function(data) {
            $scope.master = angular.copy(data);
        });
    };

} ]);
