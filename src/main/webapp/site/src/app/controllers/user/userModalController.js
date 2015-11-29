(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('UserModalController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', 'Feedback', '$modalInstance', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, UserService, Feedback, $modalInstance) {

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
            aprovado: !!Math.floor(Math.random() * 2)

          }


        $scope.login = function(){
          console.log($scope.us)
          UserService.login($scope.us).then(function(result){
            $rootScope.isLogado = true;
            $state.go('web.home');

            UserService.session().then(function(result){
              UserService.setUser(result.data);
              $rootScope.loggedUser = result.data;
              $state.go('web.home');
              $scope.closeModal();
            });

          }).catch(function(error){
            $scope.loginFailed = true;
          })

        }


        $scope.cadastro = function(){
          UserService.create($scope.newUser).then(function (result) {
            $scope.us = result.data;
            alert('Cadastro realizado com sucesso')
            console.log( '$scope.us', $scope.us);
            $state.go('web.home');
            
            $scope.login();

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