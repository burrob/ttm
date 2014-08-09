var fcoTMControllers = angular.module("fcoTMControllers", []);

/*
 * user ui controllers
 */

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

/*
 * admin ui controllers
 */

/**
 * controller for partials/admin/addplayer.html
 * 
 * create a new player
 */
fcoTMControllers.controller("AddPlayerCtrl", [ "$scope", "$http", function($scope, $http) {
    $scope.master = {};

    $scope.save = function(player) {
        $http.post("/data/admin/player/add", player).success(function(data) {
            $scope.master = angular.copy(player);
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
                    $scope.master = angular.copy(player);
                });
            };

        } ]);
