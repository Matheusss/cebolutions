(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('CarController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', 'cars', 'CarService', 'SharingDataService', '$stateParams', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, Feedback, cars, CarService, SharingDataService, $stateParams) {

        $scope.cars = cars;

        CarService.findByMarca($stateParams.marcaId).then(function(result){
          $scope.cars = result.data;
        })
      
  /*      return $scope.$on('marca:id', function(results) {
          CarService.findByMarca(results.id).then(function(result){
            $scope.carros = result.data;
          });
        });*/

        $scope.myInterval = 0;
        $scope.noWrapSlides = false;
        $scope.car = {
            red: ["http://localhost/img/mustang/red/redBack.png","http://localhost/img/mustang/red/redSide.png","http://localhost/img/mustang/red/redFront.png" ],
            yellow: ["http://localhost/img/mustang/yellow/yellowBack.png","http://localhost/img/mustang/yellow/yellowSide.png","http://localhost/img/mustang/yellow/yellowFront.png" ],
            gray: ["http://localhost/img/mustang/gray/grayBack.png","http://localhost/img/mustang/gray/graySide.png","http://localhost/img/mustang/gray/grayFront.png" ],
            white: ["http://localhost/img/mustang/white/whiteBack.png","http://localhost/img/mustang/white/whiteSide.png","http://localhost/img/mustang/white/whiteFront.png" ],
            black: ["http://localhost/img/mustang/black/blackBack.png","http://localhost/img/mustang/black/blackSide.png","http://localhost/img/mustang/black/blackFront.png" ],
            blue: ["http://localhost/img/mustang/blue/blueBack.png","http://localhost/img/mustang/blue/blueSide.png","http://localhost/img/mustang/blue/blueFront.png" ]
        };

        $scope.selectedColor = 'black';
        $scope.mudarCor = function(cor){
            
            $scope.selectedColor = cor;

        };
          
    }]);
})();