<%-- 
    Document   : view
    Created on : May 20, 2019, 11:18:07 AM
    Author     : POR
--%>

<%@page import="controllers.EyesDAO"%>
<%@page import="java.util.List"%>
<%@page import="controllers.Products"%>
<%@page import="controllers.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%-- 
    Document   : index
    Created on : Apr 8, 2019, 8:50:55 AM
    Author     : POR
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Eyes View</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="ionicons/css/ionicons.min.css" rel="stylesheet">
    <link rel="icon" href="img/fav.png" type="image/x-icon">

    <!-- main css -->
    <link href="css/style.css" rel="stylesheet">


    <!-- modernizr -->
    <script src="js/modernizr.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <!-- Preloader -->
    <div id="preloader">
        <div class="pre-container">
            <div class="spinner">
                <div class="double-bounce1"></div>
                <div class="double-bounce2"></div>
            </div>
        </div>
    </div>
    <!-- end Preloader -->

    <div class="container-fluid">
        <!-- box-header -->
        <header class="box-header">
            <div class="box-logo">
                <!--<a href="index.html"><img src="img/logo.png" width="80" alt="Logo"></a>-->
            </div>
            <!-- box-nav -->
            <a class="box-primary-nav-trigger" href="#0">
                <span class="box-menu-text">Menu</span><span class="box-menu-icon"></span>
            </a>
            <!-- box-primary-nav-trigger -->
        </header>
        <!-- end box-header -->

        <!-- nav -->
        <nav>
            <ul class="box-primary-nav">
<!--                  <li class="box-label">About me</li>-->

                <li><a href="indexv.jsp">Home</a> <i class="ion-ios-circle-filled color"></i></li>
<!--                <li><a href="register.jsp">Register</a></li>-->
                 <c:if test ="${logged==true}">
                    <a href ="LogoutController">Logout</a> 
                    </c:if>

            </ul>
        </nav>
        <!-- end nav -->

    </div>

    <!-- top bar -->
    <div class="top-bar">
        <h1>Welcome!</h1>
        <h2> <% String user =(String)request.getSession().getAttribute("user");
        out.println(user); %> </h2>
        <h4>Easy make-up</h4>
    </div>
    <!-- end top bar -->

    <!-- main-container -->
    <div class="container main-container">
        <div class="col-md-12">
            <% 
                String id=request.getParameter("id");
                String user1=(String) request.getSession().getAttribute("userid");
                List<Products> prods= EyesDAO.getInstance().getProducts(user1);
                for(Products prod: prods){
                 if(prod.getId().toString().equals(id)){
                
                
            %>

                <div class="col-md-6">
                <h1><%out.println(prod.getName());%></h3>
                <p>  </p>
                 <img src="img/<%out.println( prod.getImage());%>.jpg" alt="image" class="img-responsive" />
                
                <h3><%out.println(prod.getDescription());%></h3>
                <h2> Rating</h1>
                <h3><%out.println(prod.getRating());%></h2>
                <% } }%> 
                </div>
                

                 
                
    </div>
    </div>
    <!-- end main-container -->

    <!-- footer -->
    <footer>
        <div class="container-fluid">
            <p class="copyright">© Make-up generator</p>
        </div>
    </footer>
    <!-- end footer -->

    <!-- back to top -->
    <a href="#0" class="cd-top"><i class="ion-android-arrow-up"></i></a>
    <!-- end back to top -->



    <!-- jQuery -->
    <script src="js/jquery-2.1.1.js"></script>
    <!--  plugins -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/menu.js"></script>
    <script src="js/animated-headline.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>


    <!--  custom script -->
    <script src="js/custom.js"></script>

</body>

</html>