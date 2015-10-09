(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('UserService', [
      '$rootScope', '$http', 'httpUtils', 'urlConfig', function($rootScope, $http, httpUtils, urlConfig) {

      return {
        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/user",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id,
            method: "GET"
          });
        },
        editar: function(id, user) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id,
            method: "PUT",
            data: user,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
        excluir: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id,
            method: "DELETE"
          });
        },
        create: function(user) {
          return $http({
            url: urlConfig.baseUrl + "/user",
            method: "POST",
            data: user,
            headers: {
              "Content-Type": "application/json"
            }
          });
        }
      };
    }
  ]);

})();