(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('MainController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', 'marcasPrincipais', 'MarcaService', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, Feedback, marcasPrincipais, MarcaService) {
          
          $scope.marcas = marcasPrincipais;

          return $scope.getMarcaId = function(marca){
           MarcaService.recuperar(marca.id).then(function(result){
            console.log(result.data)
            var results = result.data;
             $rootScope.$broadcast('marca:id', results);
             return $state.go('web.car.list');
           });

          }

/*          $rootScope.$broadcast('marca:id', );
*/    }]);
})();