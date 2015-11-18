(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('UserService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {

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
        },

        login: function(params){
          return $http({
            url       : urlConfig.baseUrl + "/login/authenticate",
            method    : "POST",
            data      : $.param(params),
            headers: {
              "Content-Type": "application/x-www-form-urlencoded"
            }
          })

        },
      };
    }
  ]);

})();