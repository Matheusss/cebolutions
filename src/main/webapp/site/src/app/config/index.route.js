(function() {
  'use strict';

  angular
    .module('cebolutions')
    .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider, $urlRouterProvider, $httpProvider) {

    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    $urlRouterProvider.otherwise('/');

    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'app/views/main.html',
        controller: 'MainController',
        controllerAs: 'main'
      })

      .state('premio', {
        url:'/',
        restrict: true,
        abstract: true,
        templateUrl: 'app/views/premio/premio.html',
      })

      .state('premio.criar', {
        url:'create',
        restrict: true,
        templateUrl: 'app/views/premio/form.html',
        controller: 'CriarPremioController',
        controllerAs: 'ctrl',
        resolve: {
          premio: [
            'PremioService', function(PremioService) {
              return PremioService.findAll().then(function(result) {
                return result.data;
              });
            }
          ]
        }      
      })

      .state('premio.listar', {
        url:'list',
        restrict: true,
        templateUrl: 'app/views/premio/list.html',
        controller: 'PremioController',
        controllerAs: 'ctrl'
      });

    
  }

})();
