(function() {
  'use strict';

angular.module("cebolutions.feedback", []).service('Feedback', [
  // function() {
  //   var defaults, feedback_theme;
  //   feedback_theme = "twitter_bootstrap";
  //   defaults = {
  //     timeout: 2500,
  //     closeWith: ['click'],
  //     theme: feedback_theme,
  //     layout: "topCenter",
  //     dismissQueue: true
  //   };
  //   return {
  //     show: function(options) {
  //       return noty(_.defaults(options, defaults));
  //     },
  //     confirm: function(question, yFn, nFn) {
  //       var closeFn;
  //       closeFn = function(wrapFn, $noty) {
  //         $noty.close();
  //         if (wrapFn) {
  //           return wrapFn();
  //         }
  //       };
  //       return this.show({
  //         text: question,
  //         type: "alert",
  //         modal: true,
  //         buttons: [
  //           {
  //             addClass: 'btn btn-success',
  //             text: 'Sim, tenho certeza',
  //             onClick: _.wrap(yFn, closeFn)
  //           }, {
  //             addClass: 'btn',
  //             text: 'Não',
  //             onClick: _.wrap(nFn, closeFn)
  //           }
  //         ]
  //       });
  //     },
  //     download: function(question, noFn) {
  //       var closeFn;
  //       closeFn = function(wrapFn, $noty) {
  //         $noty.close();
  //         if (wrapFn) {
  //           return wrapFn();
  //         }
  //       };
  //       return this.show({
  //         text: question,
  //         type: "alert",
  //         modal: true,
  //         buttons: [
  //           {
  //             addClass: 'btn',
  //             text: 'Fechar',
  //             onClick: _.wrap(noFn, closeFn)
  //           }
  //         ]
  //       });
  //     },
  //     alert: function(message) {
  //       return this.show({
  //         type: 'alert',
  //         text: message
  //       });
  //     },
  //     success: function(message) {
  //       return this.show({
  //         type: 'success',
  //         text: message
  //       });
  //     },
  //     fail: function(message) {
  //       return this.show({
  //         type: 'error',
  //         text: message
  //       });
  //     }
  //   };
  // }
]);
})();