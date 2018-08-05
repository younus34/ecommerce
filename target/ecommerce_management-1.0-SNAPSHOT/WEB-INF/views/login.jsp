
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="LoginInfoController as objCtrl">
            <h1> Login Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Login </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update supplier for ID: {{ objCtrl.obj.loginId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>User Name: </td> <td><input type="text" name="username" ng-model="objCtrl.obj.username" required/> 
                            <span ng-show="objForm.username.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>password </td> <td> <input type="text" name="password" ng-model="objCtrl.obj.password" required/> 
                            <span ng-show="objForm.password.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>email </td> <td> <input type="text" name="email" ng-model="objCtrl.obj.email" required/> 
                            <span ng-show="objForm.email.$error.required" class="msg-val"></span> </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Login successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Login already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Login"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Login"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Login successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>username</th> 
                    <th>password</th>
                    <th>email</th>
                    
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.loginId"></span></td>
                    <td><span ng-bind="row.username"></span></td>
                    <td><span ng-bind="row.password"></span></td>
                    <td><span ng-bind="row.email"></span></td>
                    
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.loginId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.loginId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.loginId == objCtrl.updatedId" class="msg-success">Login successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/loginController.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html>
