(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('MainController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', 'marcasPrincipais', 'MarcaService', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, Feedback, marcasPrincipais, MarcaService) {
          
          $scope.marcas = marcasPrincipais;

          return $scope.getMarcaId = function(marca){
            return $state.go('web.car.list', {marcaId: marca.id});
          }

/*          $rootScope.$broadcast('marca:id', );
*/    }]);
})();