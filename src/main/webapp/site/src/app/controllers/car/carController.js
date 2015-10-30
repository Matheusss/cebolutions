(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('CarController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', 'cars', function($scope, $location, $timeout, $http, urlConfig, $state, Feedback, cars) {

        
        $scope.carros = cars;

        $scope.myInterval = 0;
        $scope.noWrapSlides = false;
       /* var slides = $scope.slides = [];
        
  $scope.addSlide = function() {
    var newWidth = 600 + slides.length + 1;
    slides.push({
      image: '//placekitten.com/' + newWidth + '/300',
      text: ['More','Extra','Lots of','Surplus'][slides.length % 4] + ' ' +
        ['Cats', 'Kittys', 'Felines', 'Cutes'][slides.length % 4]
    });
  };
  for (var i=0; i<4; i++) {
    $scope.addSlide();
  }
        */
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