'use strict';
angular.module("cebolutions").config(function($httpProvider, $provide) {
  $provide.factory('AppInterceptor', function($q, $injector, $rootScope, $timeout, $window, $filter,urlConfig) {

    var addLoader, messageDivider, removeLoader, requestCount, unhandledRequests, verifyRequest;

    requestCount = 0;
    messageDivider = '::';

    var verifyRequest = function(config) {
      var shouldHandle;
      shouldHandle = true;

      return shouldHandle;
    };


    var addLoader = function() {
      $rootScope.$broadcast('requestLoader:show');
      return $rootScope.loading = true;
    };


    var removeLoader = function() {
      if (!--requestCount) {
        $rootScope.$broadcast('requestLoader:hide');
        return $rootScope.loading = false;
      }
    };

    return {
      'request': function(config) {
          
          addLoader();
          //$timeout( 50000);
          requestCount++;
        
        return config;
      },
      'requestError': function(rejection) {
        if (verifyRequest(rejection.config)) {
         // removeLoader();
        }
        return $q.reject(rejection);
      },
      'response': function(response) {
        if (verifyRequest(response.config)) {
          //removeLoader();
        }
        return response || $q.when(response);
      }
    };
  });
  return $httpProvider.interceptors.push('AppInterceptor');
});