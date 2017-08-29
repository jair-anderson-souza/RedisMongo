/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("app");

app.config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider
            .state("/", {
                cache: false,
                url: "/",
                views: {
                    "header": {
                        templateUrl: "header.html"
                    },
                    "content": {
                        templateUrl: "login.html",
                        controller: "loginCtrl"
                    }
                }
            })
            .state("/login", {
                cache: false,
                url: "/login",
                views: {
                    "header": {
                        templateUrl: "header.html"
                    },
                    "content": {
                        templateUrl: "login.html",
                        controller: "loginCtrl"
                    },
                    "footer": {
                        templateUrl: "footer.html"
                    }
                }
            })
            .state("/home", {
                cache: false,
                url: "/home",
                views: {
                    "header": {
                        templateUrl: "dashboard.html",
                        controller: "homeCtrl"
                    },
                    "content": {
                        templateUrl: "home.html",
                        controller: "homeCtrl"
                    },
                    "footer": {
                        templateUrl: "footer.html"
                    }
                }
            })
            .state("/cart", {
                cache: false,
                url: "/cart",
                views: {
                    "header": {
                        templateUrl: "dashboard.html",
                        controller: "homeCtrl"
                    },
                    "content": {
                        templateUrl: "cart.html",
                        controller: "cartCtrl"
                    },
                    "footer": {
                        templateUrl: "footer.html"
                    }
                }
            });
});




