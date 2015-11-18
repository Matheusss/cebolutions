(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('UserController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', 'Feedback', 'users', function($scope, $location, $timeout, $http, urlConfig, $state, UserService, Feedback, users) {

          $scope.users = users;

          // $scope.alterarUser = function(user) {
          //   return $state.go('user.edit', {
          //     'id': user.id
          //   });
          // };














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