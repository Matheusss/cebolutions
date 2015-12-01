(function() {
  'use strict';

      angular.module('cebolutions.controllers')
      .controller('EditUserController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'UserService', '$cookies', '$modalInstance', 'us', 'EnderecoService', 'SweetAlert', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, UserService, $cookies, $modalInstance, us, EnderecoService, SweetAlert) {

          $scope.newUser = {
            nome: '',
            sobrenome: '',
            email: '',
            password: '',
            username: '',
            cpf: '',
            cnh: '',
            dataNascimento: ''
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

$scope.enderecosByUser = [];



              EnderecoService.findByUser($scope.us.id).then(function(result){
                $scope.enderecosByUser = result.data;
                $scope.formattedEndereco = $scope.enderecosByUser[0].logradouro + ", " + $scope.enderecosByUser[0].bairro + ", " + $scope.enderecosByUser[0].cidade + ", " + $scope.enderecosByUser[0].estado + " - " + $scope.enderecosByUser[0].cep;
            });

        $scope.enderecoSelected = '';

        $scope.excluirEndereco = function(){
          var index = $scope.enderecosByUser.indexOf($scope.enderecoSelected.id);
            $scope.enderecosByUser.splice(index, 1);
          EnderecoService.excluir($scope.enderecoSelected.id).then(function(result){
            alert('Endereço excluido com suvesso!');

          })
          
        }

        $scope.getEndereco = function(id){
          EnderecoService.recuperar(id).then(function(result){
            $scope.enderecoSelected = result.data;
          })
        }

        $scope.editarCadastro = function(){

          UserService.editar($scope.us.id, _.omit($scope.us, 'id')).then(function (result) {
          SweetAlert.swal("Good job!", "Cadastro atualizado com sucesso!", "success"); 
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
                cep: '',
                userId: $scope.us.id
            }             
             $scope.createEndereco = function(){
                EnderecoService.create($scope.endereco).then(function(result){
                $scope.enderecosByUser.push(result.data);
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