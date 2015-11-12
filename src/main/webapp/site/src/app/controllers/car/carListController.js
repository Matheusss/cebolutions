    (function() {
      'use strict';

      angular.module('cebolutions.controllers')
      .controller('CarListController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'carros', 'CarService', '$stateParams', 'MarcaService', '$filter', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, carros, CarService, $stateParams, MarcaService, $filter) {


          $scope.loading = true;
          $scope.cars = [];

           // $scope.marcasRestantes = marcasRestantes;
           $scope.uiRouterState = $state;
           $scope.arrayCarros = [];

           // Retorna todas as marcas e preenche o dropdown
           MarcaService.findAll().then(function(result){
            $scope.marcas = result.data;
            if($scope.uiRouterState.current.name === 'web.car.list'){
              $scope.selectedMarca = $filter('filter')($scope.marcas, {id: $stateParams.marcaId})[0];
            }
          });

           //Watch na marca selecionada e muda o conteudo de acordo
           $scope.$watch('selectedMarca', function(newVal, oldVal){
            if(newVal && oldVal && newVal != oldVal){
             CarService.findByMarca(newVal.id).then(function(result){
              if(result.data == '' || result.data == []){
                $scope.cars = [];
              } else {
                $scope.cars = result.data;
              }
              
              $stateParams.marcaId = newVal.id;
              $scope.marcaNome = newVal.nome;
              $state.go('web.car.list', {'marcaId' : newVal.id})
            }).finally(function() {
              // called no matter success or failure
              $scope.loading = false;
            });
           }
         }); 

           //Listagem apenas dos veiculos selecionados por marca
           if($scope.uiRouterState.current.name === 'web.car.list'){
             $scope.findByMarca = CarService.findByMarca($stateParams.marcaId).then(function(result){
              if(result.data == '' || result.data == []){
                $scope.cars = [];
                  MarcaService.recuperar($stateParams.marcaId).then(function(result){
                    $scope.marcaNome = result.data.nome;
                  })
              } else{
                $scope.cars = result.data;
                $scope.marcaNome = result.data[0].marca.nome;
              }
              
            }) 
           } 
           //Listagem de todos os veiculos
           else if($scope.uiRouterState.current.name === 'web.car.listAll'){
               // $scope.callAtTimeout = function() {
       // console.log("$scope.callAtTimeout - Timeout occurred");
        $scope.cars = carros;
    //}
           // $timeout( function(){ $scope.callAtTimeout(); }, 3000);
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