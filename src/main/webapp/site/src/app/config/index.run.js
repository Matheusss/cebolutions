(function() {
  'use strict';

  angular
    .module('cebolutions')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
