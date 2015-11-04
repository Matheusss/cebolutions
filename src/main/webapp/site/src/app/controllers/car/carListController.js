(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('CarListController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'carros', 'CarService', '$stateParams', 'MarcaService', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, carros, CarService, $stateParams, MarcaService) {

        $scope.cars = carros;
       // $scope.marcasRestantes = marcasRestantes;
        $scope.uiRouterState = $state;
        $scope.arrayCarros = [];

        MarcaService.findAll().then(function(result){
          $scope.marcas = result.data;
        })

          $scope.$watch('selectedMarca', function(newVal, oldVal){
            if(newVal){
               CarService.findByMarca(newVal.id).then(function(result){
                  $scope.cars = result.data;
                  $stateParams.marcaId = newVal.id;
                  $scope.marcaNome = newVal.nome;
                 // console.log($scope.uiRouterState.params.marcaId);
            })
            }
          }) 

        if($scope.uiRouterState.current.name === 'web.car.list'){
           CarService.findByMarca($stateParams.marcaId).then(function(result){
            $scope.cars = result.data;
            $scope.marcaNome = result.data[0].marca.nome;
          }) 
        } /*else if($scope.uiRouterState.current.name === 'web.car.listOthers'){
             
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