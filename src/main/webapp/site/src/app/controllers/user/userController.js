(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('UserController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', 'Feedback', '$modalInstance', function($scope, $location, $timeout, $http, urlConfig, $state, UserService, Feedback, $modalInstance) {

          $scope.users = [];
          $scope.btnDisabled = false;

          // $scope.alterarUser = function(user) {
          //   return $state.go('user.edit', {
          //     'id': user.id
          //   });
          // };

          $scope.closeModal = function(){
            $modalInstance.close();
          };

          $scope.newUser = function() {
            return $state.go('web.user.create');
          };

          return $scope.excluirUser = function(user) {
            $scope.btnDisabled = true;
            return UserService.excluir(user.id).then(function(result) {
              Feedback.success('Excluido com sucesso.');
              $scope.btnDisabled = false;
              return $scope.users = result.data;
            }, 
            function(error) {
              $scope.btnDisabled = false;
              return Feedback.fail("Erro ao excluir user. " + error.data.message);
            });
          };
        }
      ]);

  })();