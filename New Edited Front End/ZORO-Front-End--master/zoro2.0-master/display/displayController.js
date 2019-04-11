(function () {
    'use strict';

    angular
        .module('app')
        .controller('displayController', displayController);

    displayController.$inject = ['$scope', '$http'];
    function displayController($scope, $http) {
      $http.get('/display/ad_data.json').then(function(response) {
      //console.log("heya");
      console.log(response);
        $scope.items = response.data; //console.log(response);

      });
    }
})();
