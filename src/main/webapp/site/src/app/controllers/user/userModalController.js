(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('UserModalController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', '$cookies', '$modalInstance', 'SweetAlert', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, UserService, $cookies, $modalInstance, SweetAlert) {

          $rootScope.loggedUser = {};

          $scope.users = null;
          $scope.loginFailed = false;
          $scope.us = {
          }

          $scope.newUser = {
            nome: '',
            sobrenome: '',
            email: '',
            password: '',
            username: '',
            cpf: '',
            aprovado: !!Math.floor(Math.random() * 2)

          }


        $scope.login = function(){
          UserService.login($scope.us).then(function(result){
            $rootScope.isLogado = true;
            $cookies.put('isLogado', true);

            UserService.session().then(function(result){
              UserService.setUser(result.data);
              $rootScope.loggedUser = result.data;
              
              $cookies.putObject('loggedUs',result.data);
              $scope.closeModal();
            });

          }).catch(function(error){
            $scope.loginFailed = true;
          })

        }


        $scope.cadastro = function(){
          UserService.create($scope.newUser).then(function (result) {
            $scope.us = result.data;
            SweetAlert.swal("Good job!", "Cadastro realizado com sucesso!", "success");           
            $scope.closeModal();
            $state.go('web.home');

          });

        }




          $scope.newUs = function() {
            return $state.go('web.user.create');
          };

          $scope.closeModal = function(){
              $modalInstance.close();
            }

            
          $scope.$on('$destroy', function() {
            return typeof modalInstance !== "undefined" && modalInstance !== null ? modalInstance.close() : void 0;
          });
         }
      ]);

  })();