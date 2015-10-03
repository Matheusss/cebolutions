/* global malarkey:false, toastr:false, moment:false */
(function() {
  'use strict';

  angular
    .module('cebolutions')
    .constant('malarkey', malarkey)
    .constant('toastr', toastr)
    .constant('moment', moment)
    .constant('urlConfig', {
      baseUrl: '/cebolutions'
    });

})();
