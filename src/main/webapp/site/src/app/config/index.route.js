(function() {
  'use strict';

  angular
    .module('cebolutions')
    .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider, $urlRouterProvider, $httpProvider) {

    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    $urlRouterProvider.otherwise('/home');

    $stateProvider
    // .state('web', {
    //   url: '',
    //   abstract: true,
    //   views: {
    //     "": {
    //       templateUrl: 'app/views/web/web.html',
    //       controller: 'WebController'
    //     }
    //   }
    // })

      .state('home', {
        url: '/home',
        templateUrl: 'app/views/web/main.html',
        controller: 'MainController',
        controllerAs: 'main'
      })

      .state('user', {
        url           : '/',
        restrict      : true,
        abstract      : true,
        templateUrl   : 'app/views/web/user/user.html'
      })

      .state('user.create', {
        url           : 'create',
        restrict      : true,
        templateUrl   : 'app/views/web/user/form.html',
        controller    : 'CreateUserController'

      })

      .state('user.list', {
        url           : 'list',
        restrict      : true,
        templateUrl   : 'app/views/web/user/list.html',
        controller    : 'UserController',
        // resolve: {
        //   users: [
        //     'UserService', function(UserService) {
        //       return UserService.findAll().then(function(result) {
        //         return result.data;
        //       });
        //     }
        //   ]
        // }
      })

      .state('car', {
        url           : '/',
        restrict      : true,
        abstract      : true,
        templateUrl   : 'app/views/web/car/car.html'
      })


      .state('car.details', {
        url           : 'details',
        restrict      : true,
        templateUrl   : 'app/views/web/car/details.html',
        controller    : 'CarController'

      });


      // .state('premio', {
      //   url:'/',
      //   restrict: true,
      //   abstract: true,
      //   templateUrl: 'app/views/web/premio/premio.html',
      // })

      // .state('premio.criar', {
      //   url:'create',
      //   restrict: true,
      //   templateUrl: 'app/views/web/premio/form.html',
      //   controller: 'CriarPremioController',
      //   controllerAs: 'ctrl',     
      // })

      // .state('premio.listar', {
      //   url:'list',
      //   restrict: true,
      //   templateUrl: 'app/views/web/premio/list.html',
      //   controller: 'PremioController',
      //   controllerAs: 'ctrl'
      // });

    
  }

})();
