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
        window.location='index-1.html#!/dashboard';

      });
      $(".clothing").on("click",function(){
        categ='clothing';
        window.location='index-1.html#!/dashboard';

      });
      $(".tools").on("click",function(){
        categ='tools';
        window.location='index-1.html#!/dashboard';

      });
      $(".automobiles").on("click",function(){
        categ='tech';
        window.location='index-1.html#!/dashboard';

      });
      $(".home").on("click",function(){
        categ='home';
        window.location='index-1.html#!/dashboard';

      });
      $(".books").on("click",function(){
        categ='books';
        window.location='index-1.html#!/dashboard';

      });
      $(".footwears").on("click",function(){
        categ='footwears';
        window.location='index-1.html#!/dashboard';

      });
      $(".furnitures").on("click",function(){
        categ='footwears';
        window.location='index-1.html#!/dashboard';

      });
      $(".games").on("click",function(){
        categ='games';
        window.location='index-1.html#!/dashboard';

      });
      $(".misc").on("click",function(){
        categ='misc';
        window.location='index-1.html#!/dashboard';

      });


    }

})();
