

'use strict';

app.factory('Sale', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/sale/product/:saleId', {saleId: '@saleId'},
        {
            updateSale: {method: 'PUT'}
        }
        );
    }]);


app.factory('Payment', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/pay/payment/:paymentId', {paymentId: '@paymentId'},
        {
            updateOrder: {method: 'PUT'}
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
//            faculty: $resource('http://localhost:8080/ProjectStarter/faculty/facultylist/:saleId', {saleId: '@saleId'}, {
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

app.controller('SaleController', ['$scope', 'Product', 'Sale','Payment', function ($scope, Product, Sale,Payment) {
        var ob = this;
        ob.objArray = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.obj = new Sale();
        ob.obj3 = new Product();
        ob.obj4 = new Payment();
        ob.fetchAllObject = function () {
            ob.objArray = Sale.query();
            $scope.names1= ob.objArray3 = Product.query();
             $scope.names2= ob.objArray4 = Payment.query();
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
            ob.obj = Sale.get({saleId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateSale(function (object) {
                    console.log(object);
                    ob.updatedId = object.saleId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Sale.delete({saleId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Sale();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Sale();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);










