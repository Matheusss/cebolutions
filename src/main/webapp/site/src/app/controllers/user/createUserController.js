angular.module('cebolutions.controllers')
.controller('CreateUserController', [
  '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', 'Feedback', function($scope, $location, $timeout, $http, urlConfig, $state, UserService, Feedback) {

    $scope.user = {
      email: '',
      senha: '',
      cep: ''
    };



    $scope.btnDisabled = false;
    $scope.tipoForm = 'NOVO USUÁRIO';

    return $scope.save = function(user) {

      $scope.btnDisabled = true;
      UserService.create($scope.user).then(function(result) {
        console.log(result.data.cep);
        $http.get('https://viacep.com.br/ws/' + result.data.cep + '/json/').then(function(result){
          console.log(result.data);
        })
        $state.go('web.user.list');
      });


    };
  }
]);