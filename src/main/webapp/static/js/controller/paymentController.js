'use strict';





app.factory('Payment', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/pay/payment/:paymentId', {paymentId: '@paymentId'},
        {
            updatePayment: {method: 'PUT'}
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



//var app = angular.module('myApp.services', ['ngResource']);
//app.factory('Product', ['$resource', function ($resource) {
//        return {
//            faculty: $resource('http://localhost:8080/ProjectStarter/faculty/facultylist/:paymentId', {paymentId: '@paymentId'}, {
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

app.controller('PaymentController', ['$scope', 'ProductOrder', 'Payment','CustomerRegi', function ($scope, ProductOrder, Payment,CustomerRegi) {
        var ob = this;
        ob.objArray = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.obj = new Payment();
        ob.obj3 = new ProductOrder();
        ob.obj4 = new CustomerRegi();
        ob.fetchAllObject = function () {
            ob.objArray = Payment.query();
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
            ob.obj = Payment.get({paymentId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updatePayment(function (object) {
                    console.log(object);
                    ob.updatedId = object.paymentId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Payment.delete({paymentId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Payment();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Payment();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);



