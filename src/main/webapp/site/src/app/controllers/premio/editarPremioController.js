(function() {
  'use strict';
angular.module('cebolutions.controllers').controller('EditarPremioController', [
  '$scope', '$location', '$timeout', '$http', 'urlConfig', 'premio', '$state', 'PremioService', function($scope, $location, $timeout, $http, urlConfig, premio, $state, PremioService) {
    $scope.premio = premio;
    $scope.btnDisabled = false;
    $scope.tipoForm = 'EDITAR PREMIO';
    $scope.save = function() {
      var promise;
      $scope.btnDisabled = true;
      promise = PremioService.editar($scope.premio.id, $scope.premio);
      promise.success(function(result) {
        $scope.btnDisabled = false;
        // Feedback.success('Premio alterado com sucesso.');
        return $state.go('web.premio.listar');
      });
      return promise.error(function(error) {
        // Feedback.fail('Falha ao salvar premio.');
        return $scope.btnDisabled = false;
      });
    };
    return this;
  }
]);

})();