angular.module('cebolutions.controllers')
.controller('CreateUserController', [
  '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', 'Feedback', function($scope, $location, $timeout, $http, urlConfig, $state, UserService, Feedback) {
    $scope.user = {
      email: '',
      senha: ''
    };
    $scope.btnDisabled = false;
    $scope.tipoForm = 'NOVO USUÁRIO';

    return $scope.save = function(user) {
      $scope.btnDisabled = true;
      UserService.create($scope.user).then(function(result) {
        $scope.btnDisabled = false;
        $state.go('user.list');
        return Feedback.success('User salvo com sucesso.');
      });
      return function(error) {
        Feedback.fail('Falha ao salvar user.');
        return $scope.btnDisabled = false;
      };
    };
  }
]);