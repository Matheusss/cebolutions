(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('CorService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {

      return {
        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/cor",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/cor/" + id,
            method: "GET"
          });
        }

      };
    }
  ]);

})();