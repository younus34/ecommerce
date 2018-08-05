

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="CustomerController as objCtrl">
            <h1> Customer Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Customer </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Customer for ID: {{ objCtrl.obj.customerId}} </h3> 
                            </div> </td>
                    </tr>
                    
                    
                    
                    <tr>
                        <td>First Name: </td> <td><input type="text" name="firstName" ng-model="objCtrl.obj.firstName" required/> 
                            <span ng-show="objForm.firstName.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>last Name </td> <td> <input type="text" name="lastName" ng-model="objCtrl.obj.lastName" required/> 
                            <span ng-show="objForm.lastName.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>gender </td> <td> <input type="radio" name="gender" ng-model="objCtrl.obj.gender" required/> 
                            <span ng-show="objForm.gender.$error.required" class="msg-val"></span>male </td>
                        
<!--                        <td> <input type="radio" name="gender" ng-model="objCtrl.obj.gender" required/> 
                            <span ng-show="objForm.gender.$error.required" class="msg-val"></span> female</td>
                        -->
                        
                    </tr>
                    <tr>
                        <td>customerCity </td> <td> <input type="text" name="customerCity" ng-model="objCtrl.obj.customerCity" required/> 
                            <span ng-show="objForm.customerCity.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>customerAddress </td> <td> <input type="text" name="customerAddress" ng-model="objCtrl.obj.customerAddress" required/> 
                            <span ng-show="objForm.customerAddress.$error.required" class="msg-val"></span> </td>
                    </tr>
                    
                     <tr>
                        <td>customerMobile </td> <td> <input type="text" name="customerMobile" ng-model="objCtrl.obj.customerMobile" required/> 
                            <span ng-show="objForm.customerMobile.$error.required" class="msg-val"></span> </td>
                    </tr>
                     <tr>
                        <td>customerEmail </td> <td> <input type="email" name="customerEmail" ng-model="objCtrl.obj.customerEmail" required/> 
                            <span ng-show="objForm.customerEmail.$error.required" class="msg-val"></span> </td>
                    </tr>
                     <tr>
                        <td>joinDate </td> <td> <input type="text" name="joinDate" ng-model="objCtrl.obj.joinDate" required/> 
                            <span ng-show="objForm.joinDate.$error.required" class="msg-val"></span> </td>
                    </tr>
                     <tr>
                        <td>password </td> <td> <input type="password" name="password" ng-model="objCtrl.obj.password" required/> 
                            <span ng-show="objForm.password.$error.required" class="msg-val"></span> </td>
                    </tr>
                    
                    
                    
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Customer successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Customer already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Customer"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Customer"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Customer successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th>
                    <th>firstName</th>
                    <th>lastName</th>
                    <th>gender</th>
                    <th>City</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>joinDate</th>
                    <th>password</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.customerId"></span></td>
                    <td><span ng-bind="row.firstName"></span></td>
                    <td><span ng-bind="row.lastName"></span></td>
                    <td><span ng-bind="row.gender"></span></td>
                    <td><span ng-bind="row.customerCity"></span></td>
                    <td><span ng-bind="row.customerAddress"></span></td>
                     <td><span ng-bind="row.customerEmail"></span></td>
                     <td><span ng-bind="row.customerMobile"></span></td>
                     <td><span ng-bind="row.joinDate"></span></td>
                     <td><span ng-bind="row.password"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.customerId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.customerId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.customerId == objCtrl.updatedId" class="msg-success">Customer successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/customer.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
    
</html>
