(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('CarController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', function($scope, $location, $timeout, $http, urlConfig, $state, Feedback) {

        
        $scope.myInterval = 5000;
        $scope.noWrapSlides = false;
        var slides = $scope.slides = [];
        
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
        
/*        $scope.car = {
            red: ["http://192.168.1.8:80/img/mustang/red/redBack.png","http://192.168.1.8:80/img/mustang/red/redSide.png","http://192.168.1.8:80/img/mustang/red/redFront.png" ],
            yellow: ["http://192.168.1.8:80/img/mustang/yellow/yellowBack.png","http://192.168.1.8:80/img/mustang/yellow/yellowSide.png","http://192.168.1.8:80/img/mustang/yellow/yellowFront.png" ],
            gray: ["http://192.168.1.8:80/img/mustang/gray/grayBack.png","http://192.168.1.8:80/img/mustang/gray/graySide.png","http://192.168.1.8:80/img/mustang/gray/grayFront.png" ],
            white: ["http://192.168.1.8:80/img/mustang/white/whiteBack.png","http://192.168.1.8:80/img/mustang/white/whiteSide.png","http://192.168.1.8:80/img/mustang/white/whiteFront.png" ],
            black: ["http://192.168.1.8:80/img/mustang/black/blackBack.png","http://192.168.1.8:80/img/mustang/black/blackSide.png","http://192.168.1.8:80/img/mustang/black/blackFront.png" ],
            blue: ["http://192.168.1.8:80/img/mustang/blue/blueBack.png","http://192.168.1.8:80/img/mustang/blue/blueSide.png","http://192.168.1.8:80/img/mustang/blue/blueFront.png" ]
        };*/

/*        $scope.selectedColor = 'black';
        $scope.mudarCor = function(cor){
            
            $scope.selectedColor = cor;

        };*/
          
    }]);
})();