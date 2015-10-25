

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
   .controller('HeaderController', [
    '$scope', '$modal', function($scope, $modal) {
    
    var modalInstance = null;

    $scope.openModal = function(){
      modalInstance = $modal.open({
        templateUrl : 'app/views/web/user/loginModal.html',
        controller  : 'UserController',
        controllerAs: 'ctrl'
      });
    }

    $scope.closeModal = function(){
      $modalInstance.close();
    }


    $scope.$on('$destroy', function() {
      return typeof modalInstance !== "undefined" && modalInstance !== null ? modalInstance.close() : void 0;
    });


    }
  ]);

})();

 