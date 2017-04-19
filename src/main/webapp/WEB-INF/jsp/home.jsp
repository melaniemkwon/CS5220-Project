<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
 
 <!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Formbuilder Home Page</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:700,300,400">        
        <link rel="stylesheet" href="assets/vendors/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!--         <link rel="stylesheet" href="assets/vendors/bootstrap-3.3.7-dist/elegant-font/code/style.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-3.3.7-dist/css/animate.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-3.3.7-dist/css/magnific-popup.css"> -->
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/media-queries.css">
        
        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>
    
        <!-- Loader -->
		 <div class="loader">
    		<div class="loader-img"></div>
    	</div> 
		
		<!-- Top menu -->
		<nav class="navbar navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right">
						<li><a class="scroll-link" href="#top-content">home</a></li>
						<li><a class="scroll-link" href="#what-we-do">Services</a></li>
						<li><a class="link" href="login.html">Login</a></li>
						<li><a class="link" href="signup.html">Signup</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
        <!-- Page title -->
        <div class="page-title top-content">
            <div class="page-title-text wow fadeInUp" style="background-color:rgba(0, 0, 0, .25);">
            	<h1>Welcome to FormBuilder</h1>
<<<<<<< HEAD
            	 <!--<div class="page-title-bottom-link">
            		 <a class="big-link-1 btn" href="login.html">Login</a>
            		<a class="big-link-1 btn" href="signup.html">Signup</a> 
            	</div> -->
=======
            	<div class="page-title-bottom-link">
            		<a class="big-link-1 btn" href="login.html">Login</a>
            		<a class="big-link-1 btn" href="signup.html">Signup</a>
            	</div>
>>>>>>> a804ea5c9eb98b80cfef6171e799600f0417974f
            </div>
        </div>

		<!-- What we do -->
        <div class="block-3-container section-container what-we-do-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 block-3 section-description wow fadeIn">
	                    <h2>What we do</h2>
	                    <div class="divider-1 wow fadeInUp"><span></span></div>
	                    <p>
	                    	Our service helps organizations streamline their legal form application process for their clients.
	                    </p>
	                </div>
	            </div>
	            <div class="row">
                	<div class="col-sm-4 block-3-box wow fadeInUp">
	                	<div class="block-3-box-icon">
	                		<span aria-hidden="true" class="icon_pencil"></span>
	                	</div>
	                    <h3>Online Form Management</h3>
	                    <p>Reduce manual paperwork and cut down on storage space costs.</p>
                    </div>
                    <div class="col-sm-4 block-3-box wow fadeInUp">
	                	<div class="block-3-box-icon">
	                		<span aria-hidden="true" class="social_twitter"></span>
	                	</div>
	                    <h3>Simple and Intuitive</h3>
	                    <p>With just a few clicks, create a form within minutes.</p>
                    </div>
                    <div class="col-sm-4 block-3-box wow fadeInDown">
	                	<div class="block-3-box-icon">
	                		<span aria-hidden="true" class="icon_cogs"></span>
	                	</div>
	                    <h3>Automated PDF Generation</h3>
	                    <p>So your clients can conveniently download a copy for their own records.</p>
                    </div>
	            </div>
	        </div>
        </div>
        
        <!-- Clients -->
        <div class="clients-container section-container section-container-gray">
        	<div class="container">
        		<div class="row">
        			<div class="col-sm-2 clients-text wow fadeInLeft">
                    	<h3>Customers Served:</h3>
	            	</div>
	            	<div class="col-sm-10 clients wow fadeInUp">
                    	<a href="https://wrapbootstrap.com/theme/trilli-bi-fullscreen-landing-page-WB000X02N?ref=azmind" target="_blank" rel="nofollow">
                    		<img src="assets/img/clients/1.png" alt="" data-at2x="assets/img/clients/1.png">
                    	</a>
                    	<a href="https://wrapbootstrap.com/theme/areta-agency-portfolio-template-WB0L5XF38?ref=azmind" target="_blank" rel="nofollow">
                    		<img src="assets/img/clients/2.png" alt="" data-at2x="assets/img/clients/2.png">
                    	</a>
                    	<a href="https://wrapbootstrap.com/theme/seria-coming-soon-landing-page-WB05D4591?ref=azmind" target="_blank" rel="nofollow">
                    		<img src="assets/img/clients/3.png" alt="" data-at2x="assets/img/clients/3.png">
                    	</a>
                    	<a href="https://wrapbootstrap.com/theme/jesis-responsive-app-landing-page-WB085528N?ref=azmind" target="_blank" rel="nofollow">
                    		<img src="assets/img/clients/4.png" alt="" data-at2x="assets/img/clients/4.png">
                    	</a>
	            	</div>
	            </div>
        	</div>
        </div>

		<!-- Block 2 -->
        <div class="block-2-container section-container about">
	        <div class="container about">
	            <div class="row">
	            	<div class="col-sm-6 block-2-box block-2-left block-2-media wow fadeInLeft">
	            		<div class="block-2-img-container">
	            			<img src="assets/img/backgrounds/1 2.jpg">
	            			<div class="img-container-line line-1"></div>
	            			<div class="img-container-line line-2"></div>
	            			<div class="img-container-line line-3"></div>
	            		</div>
	            	</div>
	            	<div class="col-sm-6 block-2-box block-2-right wow fadeInUp">	            		
	            		<h3>Features</h3>
	            		<p>
	            			Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit 
	            			lobortis nisl ut aliquip ex ea commodo consequat.
	            		</p>
	            		<ul>
	            			<li>
	            				<span aria-hidden="true" class="icon_check list-icon"></span> Etiam processus dynamicus qui
	            			</li>
	            			<li>
	            				<span aria-hidden="true" class="icon_check list-icon"></span> Quam nunc putamus Photoshop
	            			</li>
	            			<li>
	            				<span aria-hidden="true" class="icon_check list-icon"></span> Mutationem consuetudium WordPress
	            			</li>
	            			<li>
	            				<span aria-hidden="true" class="icon_check list-icon"></span> Exerci tation ullamcorper
	            			</li>
	            		</ul>
	            	</div>
	            </div>
	        </div>
        </div>
        
		<!-- Our motto -->
        <div class="our-motto-container section-container section-container-full-bg">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 our-motto section-description wow fadeInLeftBig">
	                    <p style="background-color:rgba(0, 0, 0, .25);">
	                    	"Thanks to FormBuilder, my firm's efficiency has improved dramatically. In our technology-driven world, our clients demand prompt and reliable service available anywhere."
	                    </p>
	                </div>
	            </div>
	        </div>
        </div>
        <hr>
        <!-- Block 2 (team member) -->
        <div class="block-2-container section-container about-block-2-container">
	        <div class="container">
	            <div class="row">
	            	<div class="col-sm-4 block-2-box block-2-left block-2-media wow fadeInLeft">
	            		<div class="block-2-img-container">
	            			<img src="http://placehold.it/350x350" alt="" data-at2x="assets/img/about/1.jpg">
	            			<div class="img-container-line line-1"></div>
	            			<div class="img-container-line line-2"></div>
	            			<div class="img-container-line line-3"></div>
	            		</div>
	            	</div>
	            	<div class="col-sm-8 block-2-box block-2-right wow fadeInUp">
	            		<h3> Free Trial <span> 30 Days </span></h3>
	            		<p>
	            			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut 
	            			labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
	            		</p>
	            		<p>
	            			Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. 
	            			Mirum est notare quam littera gothica, quam nunc putamus parum claram lorem.
	            		</p>
	            		<h3>Follow Us:</h3>
 	            		<div class="about-social">
		                	<a href="#"><i class="fa fa-facebook"></i></a>
		                	<a href="#"><i class="fa fa-dribbble"></i></a>
		                    <a href="#"><i class="fa fa-twitter"></i></a>
		                    <a href="#"><i class="fa fa-pinterest"></i></a>
		                </div>
	            	</div>
	            </div>
	        </div>
        </div>

<div class="block-2-container section-container contact-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 block-2 section-description wow fadeIn">
	                	<h3>Footer</h3>
	                </div>
	            </div>
<%-- 	            <div class="row">
	            	<div class="col-sm-4 block-2-box block-2-left  wow fadeInLeft">
	            		<h3>Login</h3>
	                    <form name='loginForm' action="<c:url value='/login' />" method='post'>
	                    	
	                    	<div class="form-group"> 
	                        	<input type="text" name="username" placeholder="Username... ">
	                        </div>
	                       
	                        <div class="form-group">
	                        	<input type="password" style="color: black;" name='password' placeholder="Password..." >
	                        </div>
	                        
	                        <input class="btn" name="submit" type="submit" value="submit" />
	                    </form>
	            	</div>
	            	<div class="col-sm-4 block-2-box block-2-right contact-address wow fadeInUp">
	            		<h3>Visit us</h3>
	                    <p><span aria-hidden="true" class="icon_pin"></span>Cal state LA</p>
	                    <p><span aria-hidden="true" class="icon_phone"></span>Phone: 0039 333 12 68 347</p>
	                    <p><span aria-hidden="true" class="icon_mail"></span>Email: <a href="">hi@yourdomain.com</a></p>
	            	</div>
	            </div> --%>
	            <div class="contact-icon-container">
            		<span aria-hidden="true" class="icon_mail"></span>
            	</div>
	        </div>
        </div>
 
        <!-- Footer -->
        <footer>
	        <div class="container">
	        	<div class="row">
		        	<div class="col-sm-12">
		        		<div class="scroll-to-top">
		        			<a href="#"><i class="fa fa-chevron-up"></i></a>
		        		</div>
		        	</div>
		        </div>
	            <div class="row">
                    <div class="col-sm-7 footer-copyright">
                    	&copy;  <a href="#"> FormBuilder Inc. </a>
                    </div>
                    <div class="col-sm-5 footer-social">
                    	<a href="#"><i class="fa fa-facebook"></i></a>
	                	<a href="#"><i class="fa fa-dribbble"></i></a>
	                    <a href="#"><i class="fa fa-twitter"></i></a>
	                    <a href="#"><i class="fa fa-google-plus"></i></a>
	                    <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
	            </div>
	        </div>
        </footer>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/jquery.magnific-popup.min.js"></script>
        <script src="assets/js/waypoints.min.js"></script>
        <script src="assets/js/jquery.countTo.js"></script>
        <script src="assets/js/masonry.pkgd.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
    </body>

</html>
 
