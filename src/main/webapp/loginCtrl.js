/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("app");

app.controller("loginCtrl", function ($scope, $http, $state, $rootScope) {

    $scope.login = function (user) {
        $http.post("http://localhost:8080/RedisExample/webresources/login", user).then(function (response) {
            if (response.status === 200) {
                $rootScope.user = response.data;
                $state.go("/home");
            }else if(response.status === 204){
                console.log("401");
            } 
        }), function (response) {
            console.log("entrou");
        };
    };

});
