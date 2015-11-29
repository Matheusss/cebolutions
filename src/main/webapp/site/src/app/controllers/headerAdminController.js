

(function() {
  'use strict';
/**
  * @ngdoc function
  * @name emailOverviewWebApp.controller:AboutCtrl
  * @description
  * # AboutCtrl
  * Controller of the emailOverviewWebApp
 */
  angular.module('cebolutions.controllers')
   .controller('HeaderAdminController', [
    '$scope', function($scope) {

        $scope.tabs = [
          { title:'Dashboard', content:'admin.home', active : true },
          { title:'Vendas', content:'admin.vendas', active: false },
          { title:'Carros', content:'admin.carros', active: false },

        ];

        $scope.$watch('$scope.tabs', function(newVal, oldVal){
          if (newVal){
            newVal.active = true;
            console.log(newVal);
            oldVal.active = false;
          }
        });

/*      $scope.$watch('activeTab', function(newVal){
        if (newVal){

        }
      })*/


    }
  ]);

})();

 