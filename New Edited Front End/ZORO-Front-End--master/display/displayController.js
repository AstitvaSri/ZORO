(function () {
    'use strict';

    angular
        .module('app')
        .controller('displayController', displayController);
        console.log("hey");
    displayController.$inject = ['$scope', '$http'];
    function displayController($scope, $http) {
      $http.get('/display/tech.json').then(function(response) {
      //console.log("heya");
      console.log(itemID);
        $scope.item = response.data; //console.log(response);

      });
    }
})();
