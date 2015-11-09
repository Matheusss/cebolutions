(function() {
  'use strict';

    angular.module('cebolutions.controllers')
    .controller('VendaController', [
        '$scope', '$rootScope', '$location', '$timeout', '$http', 'urlConfig', '$state', 'Feedback', 'VendaService', '$stateParams', 'UserService', 'EnderecoService', 'ngCart', 'CarroPersonalizadoService', 'SweetAlert', function($scope, $rootScope, $location, $timeout, $http, urlConfig, $state, Feedback, VendaService, $stateParams, UserService, EnderecoService, ngCart, CarroPersonalizadoService, SweetAlert) {

            //concorda com o termos
            $scope.agreed = false;

            $scope.isCarro = false;

            $scope.disabled = false;

            $scope.carroPersonalizado = '';


            $scope.formattedEndereco = '';

            //items no carrinho
            $scope.carrinho = ngCart.getItems();
            
            //watch if enderecos
            $scope.enderecosRadio = "enderecos_cadastrados"

            $scope.cart = ngCart.getCart();
            
            $scope.user = '';

            //objeto carro personalizado
            $scope.carroVenda = {
                carroId: '',
                corId: ''
            }

            //objeto endereco
            $scope.endereco = {
                logradouro: '',
                bairro: '',
                cidade: '',
                estado: '',
                cep: ''
            }

            //objeto venda
            $scope.venda = {
                usuarioId: 1,
                carroId: '',
                valorTotal: ngCart.totalCost(),
                vendaCompleta: false

            }



                for (var i = 0; i < $scope.carrinho.length; i++) {
                   if( $scope.carrinho[i]._name == "car"){
                    $scope.carroVenda.carroId = $scope.carrinho[i]._data.id;
                    $scope.isCarro = true;
                   } else {
                    $scope.isCarro = false;
                   }
                };



            //CRIA UM CARRO PERSONALIZADO PARA VENDA
            $scope.createCarroPersonalizado = function(car){

                for (var i = 0; i < $scope.carrinho.length; i++) {
                   if( $scope.carrinho[i]._data.modelo){
                    console.log('hauahuhuahuaa', $scope.carrinho[i]._data)
                    $scope.carroVenda.carroId = $scope.carrinho[i]._data.id;
                   } else {
                    $scope.carroVenda.corId = $scope.carrinho[i]._data.id;
                   }
                };
                console.log($scope.carroVenda.carroId);
                console.log($scope.carroVenda.corId);
                CarroPersonalizadoService.create($scope.carroVenda).then(function(result){
                    $scope.carroPersonalizado = result.data;
                    $scope.venda.carroId = result.data.id;
                    
                });


             //   $scope.disabled = true;
            }

            //CRIA A VENDA
            $scope.finalizarVenda = function(){
                $scope.vendaCompleta = true;
                VendaService.create($scope.venda).then(function(result){
                    ngCart.removeItem($scope.carrinho[0]);
                    ngCart.removeItem($scope.carrinho[1]);
                    SweetAlert.swal("Compra finalizada com sucesso!", "Logo você receberá um email de confirmação!", "success");
                    

                }).finally(function(){
                    $state.go('web.home');
                });  
            }

            $scope.removeItemCart = function(item){
                SweetAlert.swal({
               title: "Você tem certeza?",
               text: "Esse item será removido de seu carrinho!",
               type: "warning",
               showCancelButton: true,
               confirmButtonColor: "#DD6B55",
               confirmButtonText: "Sim, remova!!",
               closeOnConfirm: false}, 
                function(){ 
                    ngCart.removeItemById(item.getId())
                   SweetAlert.swal("Removido!");
                });
            }


            UserService.recuperar(1).then(function(result){
                $scope.user = result.data;
                console.log(result.data)
            })

            //RECUPERA OS ENDERECOS DE UM USUARIO
            EnderecoService.findByUser(1).then(function(result){
                $scope.user.endereco = result.data;
                $scope.formattedEndereco = $scope.user.endereco[0].logradouro + ", " + $scope.user.endereco[0].bairro + ", " + $scope.user.endereco[0].cidade + ", " + $scope.user.endereco[0].estado + " - " + $scope.user.endereco[0].cep;
                console.log($scope.user.endereco)
            })
          
    }]);
})();