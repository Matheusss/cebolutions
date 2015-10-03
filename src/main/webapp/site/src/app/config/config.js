(function() {
  'use strict';

angular.module('cebolutions').config([

  '$httpProvider', function($httpProvider) {
    $httpProvider.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded';
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
  }
]);

})();