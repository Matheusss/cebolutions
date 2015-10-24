(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('CarController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', function($scope, $location, $timeout, $http, urlConfig, $state, Feedback) {

        

        $scope.car = {
            red: ["http://192.168.1.8:80/img/mustang/red/redBack.png","http://192.168.1.8:80/img/mustang/red/redSide.png","http://192.168.1.8:80/img/mustang/red/redFront.png" ],
            yellow: ["http://192.168.1.8:80/img/mustang/yellow/yellowBack.png","http://192.168.1.8:80/img/mustang/yellow/yellowSide.png","http://192.168.1.8:80/img/mustang/yellow/yellowFront.png" ],
            gray: ["http://192.168.1.8:80/img/mustang/gray/grayBack.png","http://192.168.1.8:80/img/mustang/gray/graySide.png","http://192.168.1.8:80/img/mustang/gray/grayFront.png" ],
            white: ["http://192.168.1.8:80/img/mustang/white/whiteBack.png","http://192.168.1.8:80/img/mustang/white/whiteSide.png","http://192.168.1.8:80/img/mustang/white/whiteFront.png" ],
            black: ["http://192.168.1.8:80/img/mustang/black/blackBack.png","http://192.168.1.8:80/img/mustang/black/blackSide.png","http://192.168.1.8:80/img/mustang/black/blackFront.png" ],
            blue: ["http://192.168.1.8:80/img/mustang/blue/blueBack.png","http://192.168.1.8:80/img/mustang/blue/blueSide.png","http://192.168.1.8:80/img/mustang/blue/blueFront.png" ]
        };

        $scope.selectedColor = 'black';
        $scope.mudarCor = function(cor){
            alert(cor);
            $scope.selectedColor = cor;

        };
          
    }]);
})();