/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("app");

app.controller("homeCtrl", function ($scope, $http, $rootScope, $state) {

    $http.get("http://localhost:8080/RedisExample/webresources/product").then(function (response) {
        if (response.status == 200) {
            $scope.products = response.data;
        }
    }), function (response) {

    };


    $scope.addItem = function (item) {
        $http.post("http://localhost:8080/RedisExample/webresources/cart/" + $rootScope.user.id, item).then(function (response) {
            $scope.carts = response.data;
            $state.go("/home");
        }), function (response) {
            console.log("Deu erro");
        };
        delete item.product;
        delete item.quantity;
        delete item;
    };

    $scope.goToCart = function () {
        $state.go("/cart");
    };

    $scope.goToHome = function () {
        $state.go("/home");
    };

});
