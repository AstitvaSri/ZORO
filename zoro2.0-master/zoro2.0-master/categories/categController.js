(function () {
    'use strict';

    angular
        .module('app')
        .controller('categController', categController);

    categController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function categController($location, AuthenticationService, FlashService) {
console.log(categ);
      $(".tech").on("click",function(){
        categ='tech';
        console.log(categ);
        $location.path('/dashboard')
      });


    }

})();
