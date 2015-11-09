(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('EnderecoService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {

      return {
        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/endereco",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/endereco/" + id,
            method: "GET"
          });
        },

        findByUser: function(userId) {
          return $http({
            url: urlConfig.baseUrl + "/endereco/endereco/" + userId,
            method: "GET"
          });
        },

        editar: function(id, endereco) {
          return $http({
            url: urlConfig.baseUrl + "/endereco/" + id,
            method: "PUT",
            data: endereco,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
  
        excluir: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/endereco/" + id,
            method: "DELETE"
          });
        },
        create: function(endereco) {
          return $http({
            url: urlConfig.baseUrl + "/endereco",
            method: "POST",
            data: endereco,
            headers: {
              "Content-Type": "application/json"
            }
          });
        }
      };
    }
  ]);

})();