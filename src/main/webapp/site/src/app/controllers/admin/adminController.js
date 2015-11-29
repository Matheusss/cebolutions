(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('AdminController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', 'VendaService', 'CarService', 'cars', 'carros', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, Feedback, VendaService, CarService, cars, carros) {



          //CARROS VENDIDOS
          $scope.cars = cars;
          $scope.carsName = [];
          $scope.datass = [];
          $scope.j = [];
          $scope.carros = carros;
           $scope.vendas = [];


          VendaService.findAll().then(function(result){
            $scope.vendas = result.data;
          })

            for (var i = 0; i < $scope.cars.length; i++) {
              $scope.carsName.push(cars[i].modelo);
              $scope.datass.push(cars[i].numeroVendas);                
              };



              /*EDITAR ESTOQUE*/

              $scope.editarCarro = function(id, carro) {
                CarService.editar(id, carro).then(function(result){
                  console.log('teste')
                })
              }









/*            VendaService.getByCar().then(function(result){
                  console.log(result.data);
                  $scope.cars = result.data;
                })*/



/*
               angular.forEach($scope.cars, function(value, key){


                  VendaService.getByCar(value.id).then(function(result){
                    console.log(key)
                    $scope.datass.push(result.data);

                  })
                });*/



/*                   console.log($scope.cars[$scope.j])
                   
                  VendaService.getByCar(1).then(function(result){
                    //console.log(result.data);
                    $scope.datass.push(result.data);
                  });*/
                
            
            

          
          
/*          for (var i = 0; i < $scope.cars.length; i++) {
              VendaService.getByCar($scope.cars[i].id).then(function(result){
                $scope.dataCars.push(result.data[i]);
                console.log($scope.cars[i]);
                console.log('------------------------');
                console.log(result.data)
              });
          };
*/









          // VENDAS POR MESES 
          $scope.months = [
            'JANUARY',
            'FEBRUARY',
            'MARCH',
            'APRIL',
            'MAY',
            'JUNE',
            'JULY',
            'AUGUST',
            'SEPTEMBER',
            'OCTOBER',
            'NOVEMBER',
            'DECEMBER'
          ]
          $scope.vendas = [];
         // for (var i = 0; i < $scope.months.length; i++) {
/*            console.log($scope.months[i])
            VendaService.getByMonth(1).then(function(result){
              console.log(result.data);
              $scope.vendas.push(result.data);
            });*/
         // };

          $scope.datas = [];
          for (var i = 1; i < 13; i++) {
            $scope.datas.push(i);
          };

            //console.log($scope.datas)
            $scope.labels = [$scope.months];


$scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  $scope.series = ['Series A', 'Series B'];

  $scope.data = [
    [65, 59, 80, 81, 56, 55, 40],
    [28, 48, 40, 19, 86, 27, 90]
  ];
           // $scope.data = [300, 500, 100, 40, 52, 63, 67, 76, 76, 45, 34, 12];

          
            Chart.defaults.global.colours = [
            '#3885e7', // blue
            '#ffa6f7', // light pink
            '#46BFBD', // green
            '#FDB45C', // yellow
            '#4D5360',  // dark grey
            '#b13070', // vinho
            '#003366', //dark blue
            '#024700', //dark green
            '#123acb',
            '#000',
            '#ccc',
            '#fff',
            '#edc',
            '#123'
            ]
   }]);
})();