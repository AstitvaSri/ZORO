(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function LoginController($location, AuthenticationService, FlashService) {
        var vm = this;
        //console.log("logiiiiiiiiiin");
        console.log(vm);
        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                console.log("DONE");
                console.log("WE GOT THIS : "+response);
                var response1=JSON.parse(response);
                console.log(response1);           
                if (response1.data.success) {
                    console.log("SUCCEEDED");                    
                    console.log(response1.data);
                    currEmail=vm.username;
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    $location.path('/dashboard');     
                } else {
                    FlashService.Error(response.message);
                    alert("Wrong E-mail or Password!")
                    vm.dataLoading = false;
                }
            });
        };
    }

})();
