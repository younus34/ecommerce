
'use strict';

app.factory('ProductOrder', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/order/productOrder/:orderId', {orderId: '@orderId'},
        {
            updateOrder: {method: 'PUT'}
        }
        );
    }]);


app.factory('Purchase', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/purchase/product/:purchaseId', {purchaseId: '@purchaseId'},
        {
            updatePurchase: {method: 'PUT'}
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


app.factory('Product', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/pro/product/:productId', {productId: '@productId'},
        {
            updateProduct: {method: 'PUT'}
        }
        );
    }]);
//var app = angular.module('myApp.services', ['ngResource']);
//app.factory('Product', ['$resource', function ($resource) {
//        return {
//            faculty: $resource('http://localhost:8080/ProjectStarter/faculty/facultylist/:orderId', {orderId: '@orderId'}, {
//                query: {method: 'GET', params: {}, isArray: false},
//                updateFaculty: {method: 'PUT'}
//            }),
//            tsp: $resource('http://localhost:8080/ProjectStarter/tsp/tsplist/:catId', {catId: '@catId'}, {
//                query: {method: 'GET', params: {}, isArray: false},
//                updateTsp: {method: 'PUT'}
//            })
//        };
//    }]);

//  https://stackoverflow.com/questions/17160771/angularjs-a-service-that-serves-multiple-resource-urls-data-sources

app.controller('ProductOrderController', ['$scope', 'Product', 'ProductOrder','CustomerRegi','Purchase', function ($scope, Product, ProductOrder,CustomerRegi,Purchase) {
        var ob = this;
        ob.objArray = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.objArray5 = [];
        ob.obj = new Product();
        ob.obj3 = new ProductOrder();
        ob.obj4 = new CustomerRegi();
        ob.obj5 = new Purchase();
        ob.fetchAllObject = function () {
            ob.objArray = ProductOrder.query();
            $scope.names1= ob.objArray3 = Product.query();
             $scope.names2= ob.objArray4 = CustomerRegi.query();
             $scope.names3= ob.objArray5 = Purchase.query();
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
            ob.obj = ProductOrder.get({orderId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateOrder(function (object) {
                    console.log(object);
                    ob.updatedId = object.orderId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = ProductOrder.delete({orderId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new ProductOrder();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new ProductOrder();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);








