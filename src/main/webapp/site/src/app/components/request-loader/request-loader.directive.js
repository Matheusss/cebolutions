'use strict';
angular.module("cebolutions")
    .directive("requestLoader", function() {
      return {
        restrict: 'A',
        scope: {},
        replace: true,
        templateUrl: 'request-loader/request-loader.html',
        link: function(scope, elem) {
          scope.showElement = function() {
            return elem.show();
          };
          scope.hideElement = function() {
            return elem.hide();
          };
          scope.$on('requestLoader:show', function() {
            return scope.showElement();
          });
          scope.$on('requestLoader:hide', function() {
            return scope.hideElement();
          });
          return elem.hide();
        }
      };
    });