var categ='none';
var itemID=1;
var currEmail="astitva@gmail.com";
(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'home/home.view.html',
                controllerAs: 'vm'
            })

            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'login/login.view.html',
                controllerAs: 'vm'
            })
            .when('/dashboard', {
                controller: 'dashboardController',
                templateUrl: 'dashboard/dashboard.html',
                controllerAs: 'vm'
            })

            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })
            .when('/profile', {
                controller: 'profileController',
                templateUrl: 'profile/profile.html',
                controllerAs: 'vm'
            })
            .when('/categories', {
                controller: 'categController',
                templateUrl: 'categories/categ.view.html',
                controllerAs: 'vm'
            })
            .when('/display', {
                controller: 'displayController',
                templateUrl: 'display/display.html',
                controllerAs: 'vm'
            })
            .when('/post', {
                controller: 'postController',
                templateUrl: 'post/post.html',
                controllerAs: 'vm'
            })

            .otherwise({ redirectTo: '/login' });
    }

    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login','/dashboard' ,'/register','/profile','/categories','/post','/display']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();
