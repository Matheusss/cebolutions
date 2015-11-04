    (function() {
      'use strict';

      angular.module('cebolutions.controllers')
      .controller('CarListController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'carros', 'CarService', '$stateParams', 'MarcaService', '$filter', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, carros, CarService, $stateParams, MarcaService, $filter) {



          $scope.cars = [];

           // $scope.marcasRestantes = marcasRestantes;
           $scope.uiRouterState = $state;
           $scope.arrayCarros = [];

           MarcaService.findAll().then(function(result){
            $scope.marcas = result.data;
            if($scope.uiRouterState.current.name === 'web.car.list'){
              $scope.selectedMarca = $filter('filter')($scope.marcas, {id: $stateParams.marcaId})[0];
            }
          });

           $scope.$watch('selectedMarca', function(newVal, oldVal){
            if(newVal && oldVal && newVal != oldVal){
             CarService.findByMarca(newVal.id).then(function(result){
              $scope.cars = result.data;
              $stateParams.marcaId = newVal.id;
              $scope.marcaNome = newVal.nome;
              $state.go('web.car.list', {'marcaId' : newVal.id})
            });
           }
         }); 

           if($scope.uiRouterState.current.name === 'web.car.list'){
             CarService.findByMarca($stateParams.marcaId).then(function(result){
              $scope.cars = result.data;
              $scope.marcaNome = result.data[0].marca.nome;
            }) 
           } else if($scope.uiRouterState.current.name === 'web.car.listAll'){
            $scope.cars = carros;
          }


            /*else if($scope.uiRouterState.current.name === 'web.car.listOthers'){
                 
                angular.forEach($scope.marcasRestantes, function(value, key){
                  
                  CarService.findByMarca(value.id).then(function(result){
                    $scope.arrayCarros.push(result.data);
                     return $scope.cars = $scope.arrayCarros;
                  })
                })

  }*/

          return $scope.viewCar = function(carro, marcaNome){
            return $state.go('web.car.details', { 'id' : carro.id, 'marcaNome' : marcaNome });
          }



  }]);
  })();