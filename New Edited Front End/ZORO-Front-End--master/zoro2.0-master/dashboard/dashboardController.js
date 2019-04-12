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
      $http.get('/dashboard/ad_data.json').then(function(response) {
        //console.log("heya");
      console.log(response);
        $scope.items = response.data; //console.log(response);

      });
    }
      else{
        $http.get('/dashboard/'+categ+'.json').then(function(response) {
          //console.log("heya");
        console.log(response);
          $scope.items = response.data; //console.log(response);
          categ='none';
        });
  console.log("tech");
      }
      }
})();
