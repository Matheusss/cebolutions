(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('EditUserController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', '$cookies', '$modalInstance', 'us', 'EnderecoService', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, UserService, $cookies, $modalInstance, us, EnderecoService) {

          $scope.newUser = {
            nome: '',
            sobrenome: '',
            email: '',
            password: '',
            username: '',
            cpf: '',
            cnh: '',
            dataNascimento: '',
            endereco: []
          }

          $scope.us = us;

  $scope.today = function() {
    $scope.dt = new Date();
  };
  $scope.today();

  $scope.clear = function () {
    $scope.dt = null;
  };

  // Disable weekend selection
  $scope.disabled = function(date, mode) {
    return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
  };


  $scope.maxDate = new Date(1997, 5, 22);

  $scope.open = function($event) {
    $scope.status.opened = true;
  };

  $scope.setDate = function(year, month, day) {
    $scope.dt = new Date(year, month, day);
  };

  $scope.dateOptions = {
    formatYear: 'yy',
    startingDay: 1
  };

  $scope.format = 'dd-MMMM-yyyy',

  $scope.status = {
    opened: false
  };





              EnderecoService.findByUser($scope.us.id).then(function(result){
                $scope.us.endereco = result.data;

                $scope.formattedEndereco = $scope.us.endereco[0].logradouro + ", " + $scope.us.endereco[0].bairro + ", " + $scope.us.endereco[0].cidade + ", " + $scope.us.endereco[0].estado + " - " + $scope.us.endereco[0].cep;
            });

        $scope.enderecoSelected = '';

        $scope.excluirEndereco = function(){
          var index = $scope.us.endereco.indexOf($scope.enderecoSelected.id);
          console.log($scope.us.endereco);
            $scope.us.endereco.splice(index, 1);
            console.log($scope.us.endereco);
          
        }

        $scope.teste = [];
        $scope.editarCadastro = function(){

/*        for (var i = 0; i < $scope.us.endereco.length; i++) {
          $scope.teste.push($scope.us.endereco[i].id);
        };

        $scope.us.endereco = $scope.teste;*/
        console.log($scope.us.endereco);

          UserService.editar($scope.us.id, _.omit($scope.us, 'id')).then(function (result) {
            alert('Cadastro atualizado realizado com sucesso')
            $state.go('web.home');
            $scope.closeModal();

          });

        }
            //objeto endereco
            $scope.endereco = {
                logradouro: '',
                bairro: '',
                cidade: '',
                estado: '',
                cep: ''
            }             
             $scope.createEndereco = function(){
                EnderecoService.create($scope.endereco).then(function(result){
                
                  $scope.us.endereco.push(result.data);

                });
            }

            $scope.verificarCep = function(cep){
                $http.get('https://viacep.com.br/ws/' + cep + '/json/').then(function(result){
                    $scope.endereco.cep = result.data.cep;
                    $scope.endereco.logradouro = result.data.logradouro;
                    $scope.endereco.cidade = result.data.localidade;
                    $scope.endereco.estado = result.data.uf;
                    $scope.endereco.bairro = result.data.bairro;
                })
            }
          $scope.closeModal = function(){
              $modalInstance.close();
            }

            
          $scope.$on('$destroy', function() {
            return typeof modalInstance !== "undefined" && modalInstance !== null ? modalInstance.close() : void 0;
          });
         }


      ]);

  })();