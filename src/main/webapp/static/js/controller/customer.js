'use strict';

app.factory('CustomerRegi', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/cust/customer/:customerId', {customerId: '@customerId'},
        {
            updateCustomer: {method: 'PUT'}
        }
        );
}]);


app.controller('CustomerController', ['$scope', 'CustomerRegi', function($scope, CustomerRegi){
      var ob = this;
      ob.objArray=[];
      ob.obj= new CustomerRegi();
      ob.fetchAllObject = function(){
          ob.objArray = CustomerRegi.query();
      };
      ob.fetchAllObject();
      ob.addObject = function(){
          console.log('Inside save');
          if($scope.objForm.$valid){
              ob.obj.$save(function(object){
                console.log(object);
                ob.flag='created';
                ob.reset();
                ob.fetchAllObject();
              },
              function(err){
                  console.log(err.status);
                  ob.flag = 'failed';
              }
             );
          }
          
      };
       
        ob.editObject = function(id){
            console.log('inside edit');
            ob.obj = CustomerRegi.get({customerId:id}, function(){
                ob.flag = 'edit';
            });
        };
        
       
       ob.updateObjectDetail = function(){
           console.log('Inside update');
           if($scope.objForm.$valid){
               ob.obj.$updateCustomer(function(object){
                   console.log(object);
                   ob.updatedId = object.customerId;
                   ob.reset();
                   ob.flag = 'updated';
                   ob.fetchAllObject();
               });
           }
       };
       
        ob.deleteObject = function(id){
            console.log('Inside delete');
            ob.obj = CustomerRegi.delete({ customerId: id}, function(){
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
                
            });
        };
      
        ob.reset = function(){
           ob.obj = new CustomerRegi();
           $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate = function(id){
          ob.obj = new  CustomerRegi();
          ob.flag ='';
          ob.fetchAllObject();
        };
        
        
}]);

