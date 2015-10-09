// (function() {
//   'use strict';

//     angular
//       .module('cebolutions.services')
//       .service('PremioService', [
//       '$rootScope', '$http', 'httpUtils', 'urlConfig', function($rootScope, $http, httpUtils, urlConfig) {

//       return {
//         findAll: function() {
//           return $http({
//             url: urlConfig.baseUrl + "/premio",
//             method: "GET"
//           });
//         },
//         recuperar: function(id) {
//           return $http({
//             url: urlConfig.baseUrl + "/premio/" + id,
//             method: "GET"
//           });
//         },
//         editar: function(id, premio) {
//           return $http({
//             url: urlConfig.baseUrl + "/premio/" + id,
//             method: "PUT",
//             data: premio,
//             headers: {
//               "Content-Type": "application/json"
//             }
//           });
//         },
//         excluir: function(id) {
//           return $http({
//             url: urlConfig.baseUrl + "/premio/" + id,
//             method: "DELETE"
//           });
//         },
//         create: function(premio) {
//           return $http({
//             url: urlConfig.baseUrl + "/premio",
//             method: "POST",
//             data: premio,
//             headers: {
//               "Content-Type": "application/json"
//             }
//           });
//         }
//       };
//     }
//   ]);

// })();