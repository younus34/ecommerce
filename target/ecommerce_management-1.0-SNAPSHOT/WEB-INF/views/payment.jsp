

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" /> 
        <title> Payment </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="PaymentController as objCtrl">
            <h1> Payment Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Payment </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Payment for ID: {{ objCtrl.obj.paymentId}} </h3> 
                            </div> </td>
                    </tr>

                   

                    <tr>
                        <td>ProductOrder Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.productOrder" ng-options="x.orderItem for x in names1">
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
                        <td>paymentType </td> <td><input type="text" name="orderItem" ng-model="objCtrl.obj.paymentType" required/> 
                            <span ng-show="objForm.paymentType.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>Payment date </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.paymentDate" required/> 
                            <span ng-show="objForm.paymentDate.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>discount </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.discount" required/> 
                            <span ng-show="objForm.discount.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td> grandTotal </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.grandTotal" required/> 
                            <span ng-show="objForm.grandTotal.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td> deliveryZone </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.deliveryZone" required/> 
                            <span ng-show="objForm.deliveryZone.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td> deliveryAddress </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.deliveryAddress" required/> 
                            <span ng-show="objForm.deliveryAddress.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td> netpayment </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.netpayment" required/> 
                            <span ng-show="objForm.netpayment.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td> paymentStatus </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.paymentStatus" required/> 
                            <span ng-show="objForm.paymentStatus.$error.required" class="msg-val"></span> </td>
                    </tr>
                   
                   




                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Payment successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Payment already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Payment"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Payment"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Payment successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table >
                <tr><th>ID </th> 
                    <th>ProductOrder</th> 
                    <th>customerEmail</th> 
                    <th>paymentType</th> 
                    <th>paymentDate</th> 
                    <th>discount</th>
                    <th>grandTotal</th>
                    <th>deliveryZone</th>
                     <th>deliveryAddress</th>
                      <th>netpayment</th>
                       <th>paymentStatus</th>
                   
                    
                    
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.paymentId"></span></td>
                    <td><span ng-bind="row.productOrder.orderItem"></span></td>
                     <td><span ng-bind="row.customerRegi.customerEmail"></span></td>
                    <td><span ng-bind="row.paymentType"></span></td>
                    <td><span ng-bind="row.paymentDate"></span></td>
                    <td><span ng-bind="row.discount"></span></td>
                    <td><span ng-bind="row.grandTotal"></span></td>
                    <td><span ng-bind="row.deliveryZone"></span></td>
                    <td><span ng-bind="row.deliveryAddress"></span></td>
                    <td><span ng-bind="row.netpayment"></span></td>
                    <td><span ng-bind="row.paymentStatus"></span></td>
                    
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.paymentId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.paymentId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.paymentId == objCtrl.updatedId" class="msg-success">Payment successfully updated.</span> </td> 
                </tr>	
                <!--                <tr ng-repeat="row in objCtrl.objArray2">
                                    <td><span ng-bind="row.tspName"></span></td>
                                    
                                </tr>-->
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/paymentController.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html>
