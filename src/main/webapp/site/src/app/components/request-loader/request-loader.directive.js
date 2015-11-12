'use strict';
angular.module("cebolutions")
    .directive("requestLoader", function() {
      return {
        restrict: 'A',
        scope: {},
        replace: true,
        templateUrl: 'request-loader/request-loader.html',
        link: function(scope, element) {
          scope.showElement = function() {
            return element.show();
          };
          scope.hideElement = function() {
            return element.hide();
          };
          scope.$on('requestLoader:show', function() {
            return scope.showElement();
          });
          scope.$on('requestLoader:hide', function() {
            return scope.hideElement();
          });
          return element.hide();
        }
      };
    });