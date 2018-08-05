

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
        
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
    
    <body ng-app="myApp" style="background-color: #87CEEB">

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
        <div ng-controller="CategoryController as objCtrl">
            <h1> Category Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Category </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update supplier for ID: {{ objCtrl.obj.catId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Category Name: </td> <td><input type="text" name="Category Name" ng-model="objCtrl.obj.catName" required/> 
                            <span ng-show="objForm.catName.$error.required" class="msg-val"></span> </td>
                    </tr>
                    <tr>
                        <td>catDesc </td> <td> <input type="text" name="catDesc" ng-model="objCtrl.obj.catDesc" required/> 
                            <span ng-show="objForm.catDesc.$error.required" class="msg-val"></span> </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Category successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Category already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Category"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Category"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Category successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th>
                    <th>catName</th>
                    <th>catDesc</th></tr>
                
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.catId"></span></td>
                    <td><span ng-bind="row.catName"></span></td>
                    <td><span ng-bind="row.catDesc"></span></td>

                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.catId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.catId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.catId == objCtrl.updatedId" class="msg-success">Category successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        
        </center>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/categoryController.js"></script>
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
