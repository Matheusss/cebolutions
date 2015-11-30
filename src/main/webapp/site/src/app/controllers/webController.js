

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
         .controller('WebController', ['$scope', '$rootScope', '$state', function($scope, $rootScope, $state) {
   

              $rootScope.$on("loginRequired", function() {
                if ($state.current.name !== 'web.login') {
                  $state.go("web.login");
                }
              });
              $rootScope.$on("sessionFailed", function() {
                return $log.error("Sessão não autorizada");
              });

         }]);

})();