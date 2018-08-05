'use strict';

app.factory('Category', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/com/category/:catId', {catId: '@catId'},
        {
            updateCategory: {method: 'PUT'}
        }
        );
    }]);


app.factory('SubCategory', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ecommerce_management/category/subcategory/:subCatId', {subCatId: '@subCatId'},
        {
            updateSubCategory: {method: 'PUT'}
        }
        );
    }]);


//app.factory('SupplierInfo', ['$resource', function ($resource) {
//    return $resource('http://localhost:8080/ecommerce_management/info/supplier/:supplierId', {supplierId: '@supplierId'},
//	{
//		updateSupplier: {method: 'PUT'}
//	}
//    );
//}]);


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
//            faculty: $resource('http://localhost:8080/ProjectStarter/faculty/facultylist/:productId', {productId: '@productId'}, {
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

app.controller('ProductController', ['$scope', 'Product', 'Category','SubCategory', function ($scope, Product, Category,SubCategory) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.obj = new Product();
        ob.obj2 = new Category();
        ob.obj3 = new SubCategory();
        
        ob.fetchAllObject = function () {
            ob.objArray = Product.query();
            $scope.names= ob.objArray2 = Category.query();
            $scope.names1= ob.objArray3 = SubCategory.query();
          
        };
        //$scope.names = ob.objArray2;
        console.log($scope.names+"hello");
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
            ob.obj = Product.get({productId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateProduct(function (object) {
                    console.log(object);
                    ob.updatedId = object.productId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Product.delete({productId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Product();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Product();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);








