

'use strict';

app.factory('Purchase', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/purchase/product/:purchaseId', {purchaseId: '@purchaseId'},
        {
            updatePurchase: {method: 'PUT'}
        }
        );
    }]);


app.factory('SupplierInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/info/supplier/:supplierId', {supplierId: '@supplierId'},
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
//            faculty: $resource('http://localhost:8080/ProjectStarter/faculty/facultylist/:purchaseId', {purchaseId: '@purchaseId'}, {
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

app.controller('PurchaseController', ['$scope', 'Product', 'Purchase','SupplierInfo', function ($scope, Product, Purchase,SupplierInfo) {
        var ob = this;
        ob.objArray = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.obj = new Purchase();
        ob.obj3 = new Product();
        ob.obj4 = new SupplierInfo();
        ob.fetchAllObject = function () {
            ob.objArray = Purchase.query();
            $scope.names1= ob.objArray3 = Product.query();
             $scope.names2= ob.objArray4 = SupplierInfo.query();
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
            ob.obj = Purchase.get({purchaseId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updatePurchase(function (object) {
                    console.log(object);
                    ob.updatedId = object.purchaseId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Purchase.delete({purchaseId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Purchase();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Purchase();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);










