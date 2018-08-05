
'use strict';

app.factory('LoginInfo', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/ecommerce_management/login/loginuser/:loginId', {loginId: '@loginId'},
	{
		updateLogin: {method: 'PUT'}
	}
    );
}]);
//angular.module('myApp.services', ['ngResource']).
//  factory("geoProvider", function($resource) {
//    return {
//      states: $resource('../data/states.json', {}, {
//        query: { method: 'GET', params: {}, isArray: false }
//      }),
//      countries: $resource('../data/countries.json', {}, {
//        query: { method: 'GET', params: {}, isArray: false }
//      })
//    };
//  }); https://stackoverflow.com/questions/17160771/angularjs-a-service-that-serves-multiple-resource-urls-data-sources

app.controller('LoginInfoController', ['$scope', 'LoginInfo', function($scope, LoginInfo) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new LoginInfo(); 
    ob.fetchAllObject = function(){
        ob.objArray = LoginInfo.query();
    };
    ob.fetchAllObject();
    ob.addObject = function(){
	console.log('Inside save');
	if($scope.objForm.$valid) {
	  ob.obj.$save(function(object){
	     console.log(object); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllObject();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editObject = function(id){
	    console.log('Inside edit');
        ob.obj = LoginInfo.get({ loginId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateLogin(function(object){
    		console.log(object); 
		ob.updatedId = object.loginId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = LoginInfo.delete({ loginId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new LoginInfo();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new LoginInfo();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 



