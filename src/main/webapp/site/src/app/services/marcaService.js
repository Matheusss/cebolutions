(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('MarcaService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {

      return {
        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/marca",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/marca/" + id,
            method: "GET"
          });
        },

        findByRestantes: function() {
          return $http({
            url: urlConfig.baseUrl + "/carro/marcasRestantes",
            method: "GET"
          });
        },
        findByPrincipal: function() {
          return $http({
            url: urlConfig.baseUrl + "/carro/marcasPrincipais",
            method: "GET"
          });
        },
        editar: function(id, marca) {
          return $http({
            url: urlConfig.baseUrl + "/marca/" + id,
            method: "PUT",
            data: marca,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
  
        excluir: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/marca/" + id,
            method: "DELETE"
          });
        },
        create: function(marca) {
          return $http({
            url: urlConfig.baseUrl + "/marca",
            method: "POST",
            data: marca,
            headers: {
              "Content-Type": "application/json"
            }
          });
        }
      };
    }
  ]);

})();