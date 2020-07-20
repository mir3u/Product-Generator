<%-- 
    Document   : personalFeatures
    Created on : May 15, 2019, 8:47:58 PM
    Author     : POR
--%>

<%-- 
    Document   : register
    Created on : Apr 8, 2019, 8:53:07 AM
    Author     : POR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Registration</title>

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

                <li><a href="index.jsp">Home</a> <i class="ion-ios-circle-filled color"></i></li>
                <li><a href="register.jsp">Register</a></li>
<!--                <li><a href="services.html">services</a></li>
                <li><a href="portfolio.html">portfolio</a></li>
                <li><a href="contact.html">contact me</a></li>-->


<!--
                <li class="box-label">Follow me</li>

                <li class="box-social"><a href="#0"><i class="ion-social-facebook"></i></a></li>
                <li class="box-social"><a href="#0"><i class="ion-social-instagram-outline"></i></a></li>
                <li class="box-social"><a href="#0"><i class="ion-social-twitter"></i></a></li>
                <li class="box-social"><a href="#0"><i class="ion-social-dribbble"></i></a></li>-->
            </ul>
        </nav>
        <!-- end nav -->

    </div>

    <!-- top bar -->
    <div class="top-bar">
        <h1>Register</h1>
        <p><a href="index.html">Home</a> / Register</p>
    </div>
    <!-- end top bar -->

    <!-- main-container -->
    <div class="container main-container">
        <div class="col-md-6">
           <form method="post" action="PersonalFeaturesController "> 
                
               <p>  </p>            

                <div class="form-element">
                    <label for="eyeShape">Eye Shape</label>
                    <select name="eyeShape" id="eyeShape">
                        <option>Deep set</option>
                        <option>Round eyes</option>
                        <option>Almond eyes</option>
                        <option>Monolid</option>
                        <option>hooded eyelids</option>
                        <option>protruding eyes</option>
                        <option>upturned eyes</option>
                        <option>downturned eyes</option>
                        <option>close set eyes</option>
                        <option>wide set eyes</option>

                    </select>
                </div>
               <div class="form-element">
                    <label for="eyeColor">Eye Color</label>
                    <select name="eyeColor" id="eyeColor">
                        <option>Blue</option>
                        <option>Brown</option>
                        <option>Green</option>
                        <option>Other</option>
                    </select>
                </div>
               <p> </p>
                    <div class="form-element">
                    <label for="shapeFace">Face Shape</label>
                    <select name="shapeFace" id="shapeFace">
                        <option>Round</option>
                        <option>Square</option>
                        <option>Almond eyes</option>
                        <option>Rectangle</option>
                        <option>Diamond</option>
                        <option>Heart</option>
                    </select>
                </div>
               <div class="form-element">
                    <label for="colorFace">Complexion Color</label>
                    <select name="colorFace" id="colorFace">
                        <option>Fair</option>
                        <option>Medium Fair</option>
                        <option>Light</option>
                        <option>Light Medium</option>
                        <option>Medium</option>
                        <option>Light Tan</option>
                        <option>Tan</option>
                    </select>
                </div>
               <p> </p>
                <div class="form-element">
                    <label for="lipShape">Lips Shape</label>
                    <select name="lipShape" id="lipShape">
                        <option>Heart-shaped lips</option>
                        <option>Round lips</option>
                        <option>Thin lips</option>
                        <option>Goldilocks lips</option>
                        <option>Wide lips</option>
                        <option>Plump center</option>
                        <option>Full lips</option>
                    </select>
                </div>
               <p> </p>
                <div class="form-element">
                    <label for="skinType">Skin Type</label>
                    <select name="skinType" id="skinType">
                        <option>Dry</option>
                        <option>Combination</option>
                        <option>Oily</option>
                        <option>Acne Prone</option>
                        <option>Impurities</option>
                    </select>
                </div>
                  <div class="form-element">
                      <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>  
                      
                    
            </form>
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

