

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" /> 
        <title> Product </title>
        
         <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/counterup.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/creditly.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/easing.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/easyResponsiveTabs.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/jquery.flexslider.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/jquery.wmuSlider.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/minicart.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/move-top.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/okzoom.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/waypoints.min.js" type="text/javascript"></script>



        <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/static/css/creditly.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/static/css/easy-responsive-tabs.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/static/css/flexslider.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/static/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    
    <body ng-app="myApp" style="background-color: #002d30">

        <div class="agileits_header">
            <div class="w3l_offers">
                <a href="products.html">Today's special Offers !</a>
            </div>
            <div class="w3l_search">
                <form action="#" method="post">
                    <input type="text" name="Product" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'Search a product...';
                            }" required="">
                    <input type="submit" value=" ">
                </form>
            </div>
            <div class="product_list_header">  
                <form action="#" method="post" class="last">
                    <fieldset>
                        <input type="hidden" name="cmd" value="_cart" />
                        <input type="hidden" name="display" value="1" />
                        <input type="submit" name="submit" value="View your cart" class="button" />
                    </fieldset>
                </form>
            </div>
            <div class="w3l_header_right">
                <ul>
                    <li class="dropdown profile_details_drop">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
                        <div class="mega-dropdown-menu">
                            <div class="w3ls_vegetables">
                                <ul class="dropdown-menu drp-mnu">
                                    <li><a href="login.html">Login</a></li> 
                                    <li><a href="login.html">Sign Up</a></li>
                                </ul>
                            </div>                  
                        </div>	
                    </li>
                </ul>
            </div>
            <div class="w3l_header_right1">
                <h2><a href="mail.html">Contact Us</a></h2>
            </div>
            <div class="clearfix"> </div>
        </div>
    
    
    
    
    <center>
        <div ng-controller="ProductController as objCtrl">
            <h1> Product Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Product </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Product for ID: {{ objCtrl.obj.productId}} </h3> 
                            </div> </td>
                    </tr>
                    
                     <tr>
                        <td>Category Id</td>
                        <td>
                            <select ng-model="objCtrl.obj.category" ng-options="x.catId for x in names">
                            </select>
                        </td>
                    </tr>
                    


                    <tr>
                        <td>Category Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.category" ng-options="x.catName for x in names">
                            </select>
                        </td>
                    </tr>
                    
                    

                    <tr>
                        <td>SubCategory Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.subCategory" ng-options="x.subCatName for x in names1">
                            </select>
                        </td>
                    </tr>


<!--                    <tr>
                        <td>Supplier name </td>
                        <td>
                            <select ng-model="objCtrl.obj.supplierInfo" ng-options="x.supplierName for x in names2">
                            </select>
                        </td>
                    </tr>-->
                    <tr>
                        <td>Product name </td> <td><input type="text" name="facultyCode" ng-model="objCtrl.obj.productName" required/> 
                            <span ng-show="objForm.productName.$error.required" class="msg-val">Product Code is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product description </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.productDesc" required/> 
                            <span ng-show="objForm.productDesc.$error.required" class="msg-val">productDesc  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product size </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.productSize" required/> 
                            <span ng-show="objForm.productSize.$error.required" class="msg-val">subCatDesc  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product productUrl </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.productUrl" required/> 
                            <span ng-show="objForm.productUrl.$error.required" class="msg-val">subCatDesc  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product productQty </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.productQty" required/> 
                            <span ng-show="objForm.productQty.$error.required" class="msg-val">productQty  is required.</span> </td>
                    </tr>
<!--                    <tr>
                        <td>Product productUnitPrice </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.productUnitPrice" required/> 
                            <span ng-show="objForm.productUnitPrice.$error.required" class="msg-val">productUnitPrice  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product productTotalPrice </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.productTotalPrice" required/> 
                            <span ng-show="objForm.productTotalPrice.$error.required" class="msg-val">productTotalPrice  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product purchaseDate </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.purchaseDate" required/> 
                            <span ng-show="objForm.purchaseDate.$error.required" class="msg-val">purchaseDate  is required.</span> </td>
                    </tr>
                    <tr>
                        <td> productSalePrice </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.productSalePrice" required/> 
                            <span ng-show="objForm.productSalePrice.$error.required" class="msg-val">productSalePrice  is required.</span> </td>
                    </tr>-->




                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Product successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Product already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Product"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Product"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Product successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr ><th>ID </th> 
                    <th>Supplier Name</th> 
                    <th>Cat Name</th> 
                    <th>SubCat Name</th> 
                    <th>Name</th> 
                    <th>Desc</th>
                    <th>size</th>
                    <th>Url</th>
                    <th>Qty</th>
<!--                    <th>UnitPrice</th>
                    <th>TotalPrice</th>
                    <th>purchaseDate</th>
                    <th>SalePrice</th>-->
                    
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.productId"></span></td>
<!--                    <td><span ng-bind="row.supplierInfo.supplierName"></span></td>-->
                     <td><span ng-bind="row.category.catName"></span></td>
                     <td><span ng-bind="row.subCategory.subCatName"></span></td>
                    <td><span ng-bind="row.productName"></span></td>
                    <td><span ng-bind="row.productDesc"></span></td>
                    <td><span ng-bind="row.productSize"></span></td>
                    <td><span ng-bind="row.productUrl"></span></td>
                    <td><span ng-bind="row.productQty"></span></td><!--
                    <td><span ng-bind="row.productUnitPrice"></span></td>
                    <td><span ng-bind="row.productTotalPrice"></span></td>
                     <td><span ng-bind="row.purchaseDate"></span></td>
                      <td><span ng-bind="row.productSalePrice"></span></td>-->

                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.productId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.productId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.productId == objCtrl.updatedId" class="msg-success">Product successfully updated.</span> </td> 
                </tr>	
                <!--                <tr ng-repeat="row in objCtrl.objArray2">
                                    <td><span ng-bind="row.tspName"></span></td>
                                    
                                </tr>-->
            </table>
        </div>
        
        </center>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/product_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
   
    <div class="footer">
    <div class="container">
        <div class="col-md-3 w3_footer_grid">
            <h3>information</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="events.html">Events</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a href="products.html">Best Deals</a></li>
                <li><a href="services.html">Services</a></li>
                <li><a href="short-codes.html">Short Codes</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>policy info</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="faqs.html">FAQ</a></li>
                <li><a href="privacy.html">privacy policy</a></li>
                <li><a href="privacy.html">terms of use</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>what in stores</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="pet.html">Pet Food</a></li>
                <li><a href="frozen.html">Frozen Snacks</a></li>
                <li><a href="kitchen.html">Kitchen</a></li>
                <li><a href="products.html">Branded Foods</a></li>
                <li><a href="household.html">Households</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>twitter posts</h3>
            <ul class="w3_footer_grid_list1">
                <li><label class="fa fa-twitter" aria-hidden="true"></label><i>01 day ago</i><span>Non numquam <a href="#">http://sd.ds/13jklf#</a>
                        eius modi tempora incidunt ut labore et
                        <a href="#">http://sd.ds/1389kjklf#</a>quo nulla.</span></li>
                <li><label class="fa fa-twitter" aria-hidden="true"></label><i>02 day ago</i><span>Con numquam <a href="#">http://fd.uf/56hfg#</a>
                        eius modi tempora incidunt ut labore et
                        <a href="#">http://fd.uf/56hfg#</a>quo nulla.</span></li>
            </ul>
        </div>
        <div class="clearfix"> </div>
        <div class="agile_footer_grids">
            <div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
                <div class="w3_footer_grid_bottom">
                    <h4>100% secure payments</h4>
                    <img src="${pageContext.request.contextPath}/static/images/card.png" alt=" " class="img-responsive" />
                </div>
            </div>
            
            <div class="clearfix"> </div>
        </div>
        <div class="wthree_footer_copy">
            <p>© 2016 Grocery Store. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
        </div>
    </div>
</div>
    
    
    </body>
</html>
