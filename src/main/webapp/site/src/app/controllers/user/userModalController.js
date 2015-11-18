(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('UserModalController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', 'Feedback', '$modalInstance', function($scope, $location, $timeout, $http, urlConfig, $state, UserService, Feedback, $modalInstance) {

          $scope.users = null;
          $scope.us = {}


        $scope.login = function(){
          console.log('ajsdb saS')
          UserService.login($scope.us).then(function(result){
            $state.go('web.home')
            alert('Login realizado com sucesso!')
          })
        }




          $scope.newUser = function() {
            return $state.go('web.user.create');
          };

          $scope.closeModal = function(){
              $modalInstance.close();
            }
         }
      ]);

  })();