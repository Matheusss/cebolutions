angular.module('cebolutions.controllers')
    .controller('CarController', [
        '$scope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', function($scope, $location, $timeout, $http, urlConfig, $state, Feedback) {

        $scope.car = [];

        $scope.mudarCor = function(car){
            var car = document.getElementById("car");
            alert="asdas"
            switch(cor){
                case 0:
                    car.src="../../../img/mustang/default.png";
                break;
                case 1:
                    car.src="../../../img/mustang/defaultAzul.png";
                break;
                case 2:
                    car.src="../../../img/mustang/defaultPreto.png";
                break;
                case 3:
                    car.src="../../../img/mustang/defaultAmarelo.png";
                break;
                case 4:
                    car.src="capturar16.png";
                break;
            }
        }
          
    }])