

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8" /> 
        <title> Order </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="ProductOrderController as objCtrl">
            <h1> Order Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Order </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Order for ID: {{ objCtrl.obj.orderId}} </h3> 
                            </div> </td>
                    </tr>

                   

                    <tr>
                        <td>product Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.product" ng-options="x.productName for x in names1">
                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td>Customer name </td>
                        <td>
                            <select ng-model="objCtrl.obj.customerRegi" ng-options="x.customerEmail for x in names2">
                            </select>
                        </td>
                    </tr>
                    
                     <tr>
                        <td>Customer name </td>
                        <td>
                            <select ng-model="objCtrl.obj.purchase" ng-options="x.purchaseId for x in names3">
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Item name </td> <td><input type="text" name="facultyCode" ng-model="objCtrl.obj.orderItem" required/> 
                            <span ng-show="objForm.orderItem.$error.required" class="msg-val">Order Code is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Order date </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.orderDate" required/> 
                            <span ng-show="objForm.orderDate.$error.required" class="msg-val">orderDate  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>item qty </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.itemQty" required/> 
                            <span ng-show="objForm.itemQty.$error.required" class="msg-val">subCatDesc  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Order price </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.price" required/> 
                            <span ng-show="objForm.price.$error.required" class="msg-val">subCatDesc  is required.</span> </td>
                    </tr>
                    <tr>
                        <td> totalPrice </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.totalPrice" required/> 
                            <span ng-show="objForm.totalPrice.$error.required" class="msg-val">totalPrice  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Order Status </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.orderStatus" required/> 
                            <span ng-show="objForm.orderStatus.$error.required" class="msg-val">orderStatus  is required.</span> </td>
                    </tr>
                   




                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Order successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Order already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Order"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Order"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Order successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>productName</th> 
                    <th>customerEmail</th> 
                    <th>purchaseID</th> 
                    <th>orderItem</th> 
                    <th>orderDate</th> 
                    <th>itemQty</th>
                    <th>price</th>
                    <th>totalPrice</th>
                    <th>orderStatus</th>
                    
                    
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.orderId"></span></td>
                    <td><span ng-bind="row.product.productName"></span></td>
                     <td><span ng-bind="row.customerRegi.customerEmail"></span></td>
                     <td><span ng-bind="row.purchase.purchaseId"></span></td>
                    <td><span ng-bind="row.orderItem"></span></td>
                    <td><span ng-bind="row.orderDate"></span></td>
                    <td><span ng-bind="row.itemQty"></span></td>
                    <td><span ng-bind="row.price"></span></td>
                    <td><span ng-bind="row.totalPrice"></span></td>
                    <td><span ng-bind="row.orderStatus"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.orderId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.orderId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.orderId == objCtrl.updatedId" class="msg-success">Order successfully updated.</span> </td> 
                </tr>	
                <!--                <tr ng-repeat="row in objCtrl.objArray2">
                                    <td><span ng-bind="row.tspName"></span></td>
                                    
                                </tr>-->
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/orderController.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
  
</html>
