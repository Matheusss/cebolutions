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
      .state('web', {
        url: '',
        abstract: true,
        views: {
          "": {
            templateUrl: 'app/views/web/web.html',
            controller: 'WebController'
          },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller: 'HeaderController'
          }
        }
      })

      .state('admin', {
        url: '/admin',
        abstract: true,
        views: {
          "": {
            templateUrl: 'app/views/web/web-admin.html',
            controller: 'WebAdminController'
          },
          "header-admin@web": {
            templateUrl: 'app/views/web/header-admin.html',
            controller: 'HeaderAdminController'
          }
        }
      })

      .state('admin.home', {
        url: '/home',
        controllerAs: 'main',
        views: {
          "": {
            templateUrl: 'app/views/web/main-admin.html',
            controller: 'MainController'
          },
          "header-admin@web": {
            templateUrl: 'app/views/web/header-admin.html',
            controller:  'HeaderAdminController'
          },
          "navbar-admin@web": {
            templateUrl: 'app/views/web/navbar-admin.html',
            controller:  'HeaderAdminController'
          }
        }
      })

      .state('web.home', {
        url: '/home',
        views: {
          "": {
            templateUrl: 'app/views/web/main.html',
            controller: 'MainController',
            resolve: {
              marcasPrincipais: [
                'MarcaService', function(MarcaService) {
                  return MarcaService.findByPrincipal().then(function(result) {
                    return result.data;
                  });
                }
              ]
          }
          },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller:  'HeaderController'
          }
        }
      })

      .state('web.user', {
        url           : '/user',
        restrict      : true,
        abstract      : true,
        views: {
          "": {
            templateUrl   : 'app/views/web/user/user.html'
          },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller:  'HeaderController'
          }
        }
      })

      .state('web.user.create', {
        url           : '/create',
        restrict      : true,
        views: {
          "": {
            templateUrl   : 'app/views/web/user/form.html',
            controller    : 'CreateUserController'
          },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller:  'HeaderController'
          }
        }
      })

      .state('web.user.list', {
        url           : '/list',
        restrict      : true,

        views: {
          "": {
            templateUrl   : 'app/views/web/user/list.html',
            controller    : 'UserController'
          },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller:  'HeaderController'
          },
          resolve: {
            users: [
              'UserService', function(UserService) {
                return UserService.findAll().then(function(result) {
                  return result.data;
                });
              }
            ]
          }
        }

      })

      .state('web.car', {
        url           : '/car',
        restrict      : true,
        abstract      : true,
        views: {
          "": {
            templateUrl   : 'app/views/web/car/car.html'
          },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller: 'HeaderController'
          }
        }
      })


      .state('web.car.details', {
        url           : '/details',
        restrict      : true,
        views: {
          "": {
              templateUrl   : 'app/views/web/car/details.html',
              controller    : 'CarController',
              resolve: {
                cars: [
                  'CarService', function(CarService) {
                    return null 
                  }
                ]
              }
            },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller: 'HeaderController'
          }
        }

      })

      .state('web.car.list', {
        url           : '/list',
        restrict      : true,

        views: {
          "": {
            templateUrl   : 'app/views/web/car/list.html',
            controller    : 'CarController',
            resolve: {
            cars: [
              'CarService', function(CarService) {
                return CarService.findAll().then(function(result) {
                  return result.data;
                });
              }
            ]
          }
          },
          "header@web": {
            templateUrl: 'app/views/web/header.html',
            controller:  'HeaderController'
          }         
        }


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
