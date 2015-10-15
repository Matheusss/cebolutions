(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('CarController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', 'Feedback', function($scope, $location, $timeout, $http, urlConfig, $state, UserService, Feedback) {

          $scope.car = [];

          $scope.mudarCor = function(car){
            var car = document.getElementById("car");

              switch(cor){
                case 0:
                  car.src="default.png";
                break;
                case 1:
                  car.src="defaultAzul.png";
                break;
                case 2:
                  car.src="defaultPreto.png";
                break;
                case 3:
                  car.src="defaultAmarelo.png";
                break;
                case 4:
                  car.src="capturar16.png";
                break;
              }
                    }
          

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