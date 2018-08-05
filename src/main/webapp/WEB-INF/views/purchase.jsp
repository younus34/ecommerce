

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" /> 
        <title> purchase </title>
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







    <body ng-app="myApp" >

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
        

        
        
        
        
        
        
        <div class="banner" style="background-color: #b5e7a0">
<!--            <div class="w3l_banner_nav_left">
                <nav class="navbar nav_bottom">
                     Brand and toggle get grouped for better mobile display 
                    <div class="navbar-header nav_2">
                        <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div> 
                     Collect the nav links, forms, and other content for toggling 
                    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                        <ul class="nav navbar-nav nav_1">
                            <li><a href="products.html">Branded Foods</a></li>
                            <li><a href="household.html">Households</a></li>
                            <li class="dropdown mega-dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Veggies & Fruits<span class="caret"></span></a>				
                                <div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
                                    <div class="w3ls_vegetables">
                                        <ul>	
                                            <li><a href="vegetables.html">Vegetables</a></li>
                                            <li><a href="vegetables.html">Fruits</a></li>
                                        </ul>
                                    </div>                  
                                </div>				
                            </li>
                            <li><a href="kitchen.html">Kitchen</a></li>
                            <li><a href="short-codes.html">Short Codes</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Beverages<span class="caret"></span></a>
                                <div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
                                    <div class="w3ls_vegetables">
                                        <ul>
                                            <li><a href="drinks.html">Soft Drinks</a></li>
                                            <li><a href="drinks.html">Juices</a></li>
                                        </ul>
                                    </div>                  
                                </div>	
                            </li>
                            <li><a href="pet.html">Pet Food</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Frozen Foods<span class="caret"></span></a>
                                <div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
                                    <div class="w3ls_vegetables">
                                        <ul>
                                            <li><a href="frozen.html">Frozen Snacks</a></li>
                                            <li><a href="frozen.html">Frozen Nonveg</a></li>
                                        </ul>
                                    </div>                  
                                </div>	
                            </li>
                            <li><a href="bread.html">Bread & Bakery</a></li>
                        </ul>
                    </div> /.navbar-collapse 
                </nav>
            </div>-->
            <center>
            <div class="w3l_banner_nav_right">
                
                <div ng-controller="PurchaseController as objCtrl">
            <h1 style="color: #FFFF00"> purchase Information </h1><br>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3 style="color:#d64161"> Add New purchase </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update purchase for ID: {{ objCtrl.obj.purchaseId}} </h3> 
                            </div> </td>
                    </tr>



                    <tr>
                        <td>product Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.product" ng-options="x.productId for x in names1">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>product Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.product" ng-options="x.productName for x in names1">
                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td>supplierName </td>
                        <td>
                            <select ng-model="objCtrl.obj.supplierInfo" ng-options="x.supplierName for x in names2">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Product qty </td> <td><input type="text" name="facultyCode" ng-model="objCtrl.obj.productQty" required/> 
                            <span ng-show="objForm.productQty.$error.required" class="msg-val">Product Code is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product purDate </td> <td><input type="date" name="facultyName" ng-model="objCtrl.obj.purDate" required/> 
                            <span ng-show="objForm.purDate.$error.required" class="msg-val">purDate  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product purUnitPrice </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.purUnitPrice" required/> 
                            <span ng-show="objForm.purUnitPrice.$error.required" class="msg-val">subCatDesc  is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product purTotalPrice </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.purTotalPrice" required/> 
                            <span ng-show="objForm.purTotalPrice.$error.required" class="msg-val">subCatDesc  is required.</span> </td>
                    </tr>






                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">purchase successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">purchase already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add purchase"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update purchase"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">purchase successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>pro ID</th> 
                    <th>pro Name</th> 
                    <th>suppliername</th> 
                    <th>qty</th> 
                    <th>purDate</th> 
                    <th>purUnitPrice</th> 
                    <th>purTotalPrice</th> 




                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.purchaseId"></span></td>
                    <td><span ng-bind="row.product.productId"></span></td>
                    <td><span ng-bind="row.product.productName"></span></td>
                    <td><span ng-bind="row.supplierInfo.supplierName"></span></td>
                    <td><span ng-bind="row.productQty"></span></td>
                    <td><span ng-bind="row.purDate"></span></td>
                    <td><span ng-bind="row.purUnitPrice"></span></td>
                    <td><span ng-bind="row.purTotalPrice"></span></td>

                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.purchaseId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.purchaseId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.purchaseId == objCtrl.updatedId" class="msg-success">purchase successfully updated.</span> </td> 
                </tr>	
                <tr ng-repeat="row in objCtrl.objArray2">
                    <td><span ng-bind="row.tspName"></span></td>

                </tr>
            </table>
        </div>
                
               
            </div>
                  </center>
            <div class="clearfix"></div>
        </div>
        
        
        
        
        


    
      
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/purchaseController.js"></script>
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
