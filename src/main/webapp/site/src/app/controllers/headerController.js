

(function() {
  'use strict';
/**
  * @ngdoc function
  * @name emailOverviewWebApp.controller:AboutCtrl
  * @description
  * # AboutCtrl
  * Controller of the emailOverviewWebApp
 */
  angular.module('cebolutions.controllers')
   .controller('HeaderController', [
    '$scope', '$modal', 'UserService', '$rootScope', '$state', 'store', '$cookies', 'ngCart', function($scope, $modal, UserService, $rootScope, $state, store, $cookies, ngCart) {
   /**/

      $scope.isLogged = $cookies.get('isLogado');
      $scope.logged = $cookies.getObject('loggedUs');

      if ($scope.isLogged) {
        $rootScope.isLogado = true;
        $rootScope.loggedUser = $scope.logged;
      } else {
        $rootScope.isLogado = false;
      }


      $scope.verifyLogin = function(){
        if ($rootScope.isLogado){
            $state.go('admin.home');
        } else {
            $state.go('web.login');

        }
      }

    $scope.logout = function(){
      UserService.logout().then(function(result){
        
        $cookies.remove('isLogado');
        $cookies.remove('loggedUs');

        $rootScope.$broadcast('ngCart:itemRemoved', {});
        $rootScope.$broadcast('ngCart:change', {});
        ngCart.empty();
        localStorage.removeItem('cart');
        
        $rootScope.isLogado = false;
        $state.go('web.home');
      })
    }
   
   $scope.cart = store.get('cart');

   $scope.userCart = {
    cart: store.get('cart'),
    user: $scope.logged
   }

  $cookies.putObject('userCart', $scope.userCart);

  $scope.editCadastro = function(){


    return $state.go('web.user.edit', {'id': $rootScope.loggedUser.id});

console.log($rootScope.loggedUser.id);
  }
  




    }
  ]);

})();

 