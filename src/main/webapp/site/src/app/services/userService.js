(function() {
  'use strict';

    angular
      .module('cebolutions.services')
      .service('UserService', [
      '$rootScope', '$http', 'urlConfig', function($rootScope, $http, urlConfig) {
      
      var user;
      user = {};
      

      return {

        findAll: function() {
          return $http({
            url: urlConfig.baseUrl + "/user",
            method: "GET"
          });
        },
        recuperar: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id,
            method: "GET"
          });
        },

        recuperarSenha: function(id, user) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id + "/senha",
            method: "PUT",
            data: user,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
        atualizarEnderecos: function(id, user) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id + "/endereco",
            method: "PUT",
            data: user,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
        editar: function(id, user) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id,
            method: "PUT",
            data: user,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },
  
        excluir: function(id) {
          return $http({
            url: urlConfig.baseUrl + "/user/" + id,
            method: "DELETE"
          });
        },
        create: function(user) {
          return $http({
            url: urlConfig.baseUrl + "/user",
            method: "POST",
            data: user,
            headers: {
              "Content-Type": "application/json"
            }
          });
        },

        login: function(params){
          return $http({
            url       : urlConfig.baseUrl + "/login/authenticate",
            method    : "POST",
            data      : $.param(params),
            headers: {
              "Content-Type": "application/x-www-form-urlencoded"
            }
          })

        },

        logout: function(){
          return $http({
            url     :   urlConfig.baseUrl + "/logout",
            method  :   "POST",
            headers: {
              "Content-Type": "application/x-www-form-urlencoded"
            }
          })
        },


        getUser: function(){
          return user || null;
        },
        setUser: function(session) {
          return user = session;
        },
        session: function() {
          return $http.get(urlConfig.baseUrl + "/user/logged");
        },
        checkSession: function() {
          var that;
          that = this;
          return this.session().then(function(result) {
            return that.setUser(result.data);
          }, function(error) {
            if (error.status === 500) {
              return $rootScope.$emit('sessionFailed');
            }
          });
  }
      };
    }
  ]);

})();