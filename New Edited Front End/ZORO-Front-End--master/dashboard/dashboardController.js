(function () {
    'use strict';

    angular
        .module('app')
        .controller('dashboardController', dashboardController);

    dashboardController.$inject = ['$scope', '$http'];
    function dashboardController($scope, $http) {
  //    console.log(categ);

      if(categ=='none')
{
      $http.get('http://localhost:7070/spring-rest-demo/zoroapi/allProducts').then(function(response) {
        
      console.log(response);
        $scope.items = response.data; //console.log(response);

      });
    }
      else{
        $http.get('http://localhost:7070/spring-rest-demo/zoroapi/getCategory/'+categ+'/').then(function(response) {
         
        console.log(response);
          $scope.items = response.data; //console.log(response);
          categ='none';
        });
          console.log(categ);
      }

      $scope.getit=function(a,b){
        console.log("details");

      itemID=a.item.pid+b;
      console.log(itemID);
      window.location='index-1.html#!/display';
      }



      }







})();
/*
$("#mybtn").on("click",function(){
  console.log("called");
  console.log($(this).attr('class').split(' ')[2]);
})
*/
