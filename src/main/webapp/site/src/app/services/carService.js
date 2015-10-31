(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('CarService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {

      return {
        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/carro",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/carro/" + id,
            method: "GET"
          });
        },

        findByMarca: function(marcaId) {
          return $http({
            url: urlConfig.baseUrl + "/carro/marcas/" + marcaId,
            method: "GET"
          });
        },

        editar: function(id, carro) {
          return $http({
            url: urlConfig.baseUrl + "/carro/" + id,
            method: "PUT",
            data: carro,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
  
        excluir: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/carro/" + id,
            method: "DELETE"
          });
        },
        create: function(carro) {
          return $http({
            url: urlConfig.baseUrl + "/carro",
            method: "POST",
            data: carro,
            headers: {
              "Content-Type": "application/json"
            }
          });
        }
      };
    }
  ]);

})();