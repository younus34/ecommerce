
'use strict';

app.factory('OrderDetails', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/orderdetail/details/:orderDetailId', {orderDetailId: '@orderDetailId'},
        {
            updateOrderDetail: {method: 'PUT'}
        }
        );
    }]);





app.factory('ProductOrder', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/order/productOrder/:orderId', {orderId: '@orderId'},
        {
            updateOrder: {method: 'PUT'}
        }
        );
    }]);


app.factory('CustomerRegi', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/cust/customer/:customerId', {customerId: '@customerId'},
        {
            updateCustomer: {method: 'PUT'}
        }
        );
}]);



app.controller('OrderdetailController', ['$scope', 'ProductOrder', 'OrderDetails','CustomerRegi', function ($scope, ProductOrder, OrderDetails,CustomerRegi) {
        var ob = this;
        ob.objArray = [];
        ob.objArray3 = [];
        ob.objArray3 = [];
        ob.obj = new OrderDetails();
        ob.obj3 = new ProductOrder();
        ob.obj4 = new CustomerRegi();
        
        ob.fetchAllObject = function () {
            ob.objArray = OrderDetails.query();
            $scope.names1= ob.objArray3 = ProductOrder.query();
             $scope.names2= ob.objArray4 = CustomerRegi.query();
             
        };
        //$scope.names = ob.objArray2;
        console.log($scope.names1+"hello");
        ob.fetchAllObject();
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.objForm.$valid) {
                //ob.obj.tspInfo= ob.obj2;
                ob.obj.$save(function (object) {
                    console.log(object);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllObject();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = OrderDetails.get({orderDetailId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateOrderDetail(function (object) {
                    console.log(object);
                    ob.updatedId = object.orderDetailId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = OrderDetails.delete({orderDetailId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new OrderDetails();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new OrderDetails();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);




