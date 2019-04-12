(function () {
    'use strict';

    angular
        .module('app')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = register;

        function register() {

            /////////////
          //  function Validate() {
       //let password = document.getElementById("txtPassword").value;
       //let confirmPassword = document.getElementById("txtConfirmPassword").value;
       if (vm.user.password != vm.user.confirmPassword) {
           alert("Passwords do not match.");
           return false;
       }
    //   return true;
  // }
            ////////////

            vm.dataLoading = true;
            UserService.Create(vm.user)
                .then(function (response) {
                    if (response.found==false) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                      console.log("values"+JSON.stringify(response));

                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        }
    }

})();
