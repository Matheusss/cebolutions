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



    var checkSession, noCache;

    noCache = function(url) {
      return url + "?_=" + (Math.random());
    };

    checkSession = function(request) {
      if (request.status === 401) {
        alert("Não autenticado");
        $rootScope.$emit("loginRequired");
        $rootScope.isLogado = false;
      }
      if (request.status === 0) {
        $rootScope.$emit("loginRequired");
        return $rootScope.isLogado = false;
      }
    };
    var setRequestHeader;

    setRequestHeader = function(config) {
      if (config.method === 'DELETE') {
        config.headers['X-HTTP-Method-Override'] = config.method;
      }
    };


    return {
      'request': function(config) {
        setRequestHeader(config);

        return config || $q.when(config);
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