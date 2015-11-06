

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
          { title:'Dashboard', content:'admin.home' },
          { title:'Vendas', content:'admin.vendas', disabled: true }
        ];

/*      $scope.$watch('activeTab', function(newVal){
        if (newVal){

        }
      })*/


    }
  ]);

})();

 