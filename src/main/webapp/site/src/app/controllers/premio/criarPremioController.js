// (function() {
//   'use strict';

// angular.module('cebolutions.controllers').controller('CriarPremioController', [
//   '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'PremioService', function($scope, $location, $timeout, $http, urlConfig, $state, PremioService) {
//     $scope.premio = {
//       nome: '',
//       valor: ''
//     };

//     $scope.btnDisabled = false;
//     $scope.tipoForm = 'NOVO PREMIO';

//     return $scope.save = function(premio) {

//       var promise;
//       $scope.btnDisabled = true;
//       promise = PremioService.create($scope.premio);

//       promise.success(function(result) {
//         $scope.btnDisabled = false;
//         // Feedback.success('Premio salvo com sucesso.');
//         return $state.go('premio.listar');
//       });
      
//       return promise.error(function(error) {
//         // Feedback.fail('Falha ao salvar premio.');
//         return $scope.btnDisabled = false;
//       });
//     };
//   }
//   ]);
// })();