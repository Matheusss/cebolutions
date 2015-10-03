(function() {
  'use strict';

angular.module('cebolutions.controllers').controller('PremioController', [
  '$scope', '$location', '$timeout', '$http', 'urlConfig', 'premio', '$state', 'PremioService', function($scope, $location, $timeout, $http, urlConfig, premio, $state, PremioService) {
    $scope.premio = premio;
    $scope.btnDisabled = false;
    $scope.novoPremio = function() {
      return $state.go('premio.criar');
    };
    
    // $scope.editarPremio = function(premio) {
    //   return $state.go('premio.editar', {
    //     'id': premio.id
    //   });
    // };
    $scope.listPremio = function() {
      return $state.go('premio.listar');
    };
    $scope.excluirPremio = function(premio) {
      $scope.btnDisabled = true;
        PremioService.excluir(premio.id).then(function(result) {
          // Feedback.success('Excluido com sucesso.');
          $state.reload();
          return $scope.btnDisabled = false;
        }, function(error) {
          $scope.btnDisabled = false;
          // return Feedback.fail("Erro ao excluir premio. " + error.data.message);
        });
      
      $state.reload();
      return $scope.btnDisabled = false;
    };
  }
]);
})();