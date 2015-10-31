
(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .factory('SharingDataService', [function() {

       var marcaId = '';

       return {
              getMarcaId : function (){
                return this.marcaId;
            },

              setMarcaId :function (id){
                this.marcaId = id;
            }
        }

       }
    
  ]);

})();