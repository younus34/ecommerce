

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>
        <meta charset="UTF-8" /> 
        <title> OrderDetails </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="OrderdetailController as objCtrl">
            <h1> OrderDetails Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New OrderDetails </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update OrderDetails for ID: {{ objCtrl.obj.orderDetailId}} </h3> 
                            </div> </td>
                    </tr>

                   

                    <tr>
                        <td>product Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.productOrder" ng-options="x.orderId for x in names1">
                            </select>
                        </td>
                    </tr>


<!--                    <tr>
                        <td>Customer name </td>
                        <td>
                            <select ng-model="objCtrl.obj.customerRegi" ng-options="x.customerEmail for x in names2">
                            </select>
                        </td>
                    </tr>-->
                    <tr>
                        <td>Order Qty </td> <td><input type="text" name="orderQty" ng-model="objCtrl.obj.orderQty" required/> 
                            <span ng-show="objForm.orderQty.$error.required" class="msg-val">OrderDetails Code is required.</span> </td>
                    </tr>
                    
                   




                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">OrderDetails successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">OrderDetails already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add OrderDetails"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update OrderDetails"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">OrderDetails successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>productOrder</th>
                    <th>orderQty</th>
                     
                    
                    
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.orderDetailId"></span></td>
                    <td><span ng-bind="row.productOrder.orderDate"></span></td>
                    <td><span ng-bind="row.orderQty"></span></td>
<!--                    <td><span ng-bind="row.customerRegi.customerEmail"></span></td>-->
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.orderDetailId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.orderDetailId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.orderDetailId == objCtrl.updatedId" class="msg-success">OrderDetails successfully updated.</span> </td> 
                </tr>	
                <!--                <tr ng-repeat="row in objCtrl.objArray2">
                                    <td><span ng-bind="row.tspName"></span></td>
                                    
                                </tr>-->
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/orderDetailController.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
    
</html>
