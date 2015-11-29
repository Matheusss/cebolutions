(function() {
  'use strict';

  angular
    .module('cebolutions')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }



  angular
    .module('cebolutions')
    .run(['$rootScope', '$state', '$modalStack', 'UserService', function($rootScope, $state, $modalStack, UserService) {
    
      return $rootScope.isLogado = false;

      var clearModals;

      clearModals = function() {
        var topModal;
        topModal = $modalStack.getTop();
        if (topModal) {
          return $modalStack.dismiss(topModal.key);
        }
      };


      var checkLogin;

      checkLogin = function(state, ev) {
        var checkRoute;
        checkRoute = function() {
          if (state.restrict && !UserService.getUser().id) {
            ev.preventDefault();
            return $state.go("web.login", {
              redir: state.name
            });
          }
        };
        if (_.isEmpty(UserService.getUser())) {
          return UserService.checkSession().then(function() {
            checkRoute();
          });
        } else {
          if (state.restrict) {
            return UserService.checkSession().then(function() {
              checkRoute();
            });
          }
        }
      };



      $rootScope.$on("$stateChangeError", function(event, toState, toParams) {
        return clearModals();
      });

      $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams) {
        return clearModals();
      });

      $rootScope.$on("$stateChangeSuccess", function(event, toState, toParams, fromState, fromParams) {
        clearModals();
        $rootScope.$broadcast("closeWebSocketConnection", {
          toState: toState,
          fromState: fromState
        });
        return checkLogin(toState, event);
      });
      


    }
  ]);

})();

