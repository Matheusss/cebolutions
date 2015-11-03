(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('VendaService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {

      return {
        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/venda",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/venda/" + id,
            method: "GET"
          });
        },

        editar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/venda/carrosVendidos" + id,
            method: "GET"

          });
        },
  
        excluir: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/venda/" + id,
            method: "DELETE"
          });
        },
        create: function(venda) {
          return $http({
            url: urlConfig.baseUrl + "/venda",
            method: "POST",
            data: venda,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },

        getByMonth: function(month){
          return $http({
            url: urlConfig.baseUrl + "/venda/" + month,
            method: "GET"
          });
        },
        getByCar: function() {
          return $http({
            url: urlConfig.baseUrl + "/venda/carrosVendidos",
            method: "GET"
          });
        },
      };
    }
  ]);

})();