(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('CarroPersonalizadoService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {

      return {
        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/carro/customizar/",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/carro/customizar/" + id,
            method: "GET"
          });
        },

        editar: function(id, carro) {
          return $http({
            url: urlConfig.baseUrl + "/carro/customizar/" + id,
            method: "PUT",
            data: carro,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
  
        excluir: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/carro/customizar/" + id,
            method: "DELETE"
          });
        },
        create: function(carro) {
          return $http({
            url: urlConfig.baseUrl + "/carro/customizar/",
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