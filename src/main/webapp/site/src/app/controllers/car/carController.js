(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('CarController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', 'CarService', '$stateParams', 'carro', 'cores', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, Feedback, CarService, $stateParams, carro, cores) {

        $scope.carro = carro;
        $scope.cores = cores;
        $scope.marcaNome = $stateParams.marcaNome;
        console.log(carro)

        $scope.myInterval = 0;
        $scope.noWrapSlides = false;
        $scope.car = {
            red: ["http://localhost/img/mustang/red/redFront.png","http://localhost/img/mustang/red/redSide.png","http://localhost/img/mustang/red/redBack.png" ],
            yellow: ["http://localhost/img/mustang/yellow/yellowFront.png","http://localhost/img/mustang/yellow/yellowSide.png","http://localhost/img/mustang/yellow/yellowBack.png" ],
            gray: ["http://localhost/img/mustang/gray/grayFront.png","http://localhost/img/mustang/gray/graySide.png", "http://localhost/img/mustang/gray/grayBack.png" ],
            white: ["http://localhost/img/mustang/white/whiteFront.png","http://localhost/img/mustang/white/whiteSide.png", "http://localhost/img/mustang/white/whiteBack.png"],
            black: ["http://localhost/img/mustang/black/blackFront.png","http://localhost/img/mustang/black/blackSide.png", "http://localhost/img/mustang/black/blackBack.png" ],
            blue: ["http://localhost/img/mustang/blue/blueFront.png","http://localhost/img/mustang/blue/blueSide.png","http://localhost/img/mustang/blue/blueBack.png" ]
        };

        $scope.selectedColor = 'black';
        $scope.mudarCor = function(cor){
            
            $scope.selectedColor = cor;

        };
          
    }]);
})();