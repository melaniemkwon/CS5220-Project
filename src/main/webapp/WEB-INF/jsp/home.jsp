<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="jumbotron">
		<h2>Welcome to Formbuilder</h2>
	</div>
	<a href="/formbuilder/login"><button type="submit" class="btn btn-raised btn-primary">
		 Login </button></a>
</div>
 --%>
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
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/elegant-font/code/style.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
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
						<!-- <li><a class="scroll-link" href="#portfolio">Portfolio</a></li> -->
						<li><a class="scroll-link" href="#about">About</a></li>
						<!-- <li><a class="scroll-link" href="#contact">Login</a></li> -->
					</ul>
				</div>
			</div>
		</nav>
		
        <!-- Page title -->
        <div class="page-title top-content">
            <div class="page-title-text wow fadeInUp">
            	<h1>Welcome to Form Builder website</h1>
            	<!-- <p>Thank you for choosing us</p> -->
            	<div class="page-title-bottom-link">
            		<!-- <a class="big-link-1 btn scroll-link" href="#pricing-2">Start now</a> -->
            		<a class="big-link-1 btn scroll-link" href="#contact">Login</a>
            	</div>
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
	                    	Our website helps orgnizations and company agents to reduce user work by creating online forms from PDF forms
	                    </p>
	                </div>
	            </div>
	            <div class="row">
                	<div class="col-sm-3 block-3-box wow fadeInUp">
	                	<div class="block-3-box-icon">
	                		<span aria-hidden="true" class="icon_pencil"></span>
	                	</div>
	                    <h3>User</h3>
	                    <p>User will fill once and never again</p>
                    </div>
                    <div class="col-sm-3 block-3-box wow fadeInDown">
	                	<div class="block-3-box-icon">
	                		<span aria-hidden="true" class="icon_cogs"></span>
	                	</div>
	                    <h3>Forms</h3>
	                    <p>You can create multiple forms for different users</p>
                    </div>
                   <!--  <div class="col-sm-3 block-3-box wow fadeInUp">
	                	<div class="block-3-box-icon">
	                		<span aria-hidden="true" class="social_twitter"></span>
	                	</div>
	                    <h3>Social Media</h3>
	                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                    <div class="col-sm-3 block-3-box wow fadeInDown">
	                	<div class="block-3-box-icon">
	                		<span aria-hidden="true" class="icon_lightbulb"></span>
	                	</div>
	                    <h3>Branding</h3>
	                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div> -->
	            </div>
	        </div>
        </div>
        
        <!-- Clients -->
        <div class="clients-container section-container section-container-gray">
        	<div class="container">
        		<div class="row">
        			<div class="col-sm-2 clients-text wow fadeInLeft">
                    	<h3>We've worked with these guys:</h3>
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
        <div class="block-2-container section-container">
	        <div class="container">
	            <div class="row">
	            	<div class="col-sm-6 block-2-box block-2-left block-2-media wow fadeInLeft">
	            		<div class="block-2-img-container">
	            			<img src="assets/img/about/4.jpg" alt="" data-at2x="assets/img/about/4.jpg">
	            			<div class="img-container-line line-1"></div>
	            			<div class="img-container-line line-2"></div>
	            			<div class="img-container-line line-3"></div>
	            		</div>
	            	</div>
	            	<div class="col-sm-6 block-2-box block-2-right wow fadeInUp">	            		
	            		<h3>We love web design</h3>
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
        
        <!-- Block 2 -->
        <!-- <div class="block-2-container section-container section-container-gray">
	        <div class="container">
	            <div class="row">
	            	<div class="col-sm-6 block-2-box block-2-left wow fadeInLeft">
	            		<h3>We design interfaces</h3>
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
	            	<div class="col-sm-6 block-2-box block-2-right block-2-media wow fadeInUp">
	            		<div class="block-2-img-container">
	            			<img src="assets/img/about/5.jpg" alt="" data-at2x="assets/img/about/5.jpg">
	            			<div class="img-container-line line-1"></div>
	            			<div class="img-container-line line-2"></div>
	            			<div class="img-container-line line-3"></div>
	            		</div>
	            	</div>
	            </div>
	        </div>
        </div>
        
        Counters
        <div class="counters-container section-container section-container-full-bg">
        	<div class="container">
        		<div class="row">
	            	<div class="col-sm-3 counter-box wow fadeInUp">
                    	<h4 data-from="0" data-to="12">0</h4>
                    	<p>Years of experience</p>
	            	</div>
	            	<div class="col-sm-3 counter-box wow fadeInDown">
                    	<h4 data-from="0" data-to="274">0</h4>
                    	<p>Projects completed</p>
	            	</div>
	            	<div class="col-sm-3 counter-box wow fadeInUp">
                    	<h4 data-from="0" data-to="19295">0</h4>
                    	<p>Lines of code</p>
	            	</div>
	            	<div class="col-sm-3 counter-box wow fadeInDown">
                    	<h4 data-from="0" data-to="8296">0</h4>
                    	<p>Cups of coffee</p>
	            	</div>
	            </div>
        	</div>
        </div>
        
        Portfolio
        <div class="portfolio-container section-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 portfolio section-description wow fadeIn">
	                	<h2>Our portfolio</h2>
	                    <div class="divider-1 wow fadeInUp"><span></span></div>
	                    <p>
	                    	Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum 
	                    	est notare quam littera gothica, quam nunc putamus parum claram lorem.
	                    </p>
	                </div>
	            </div>
	            <div class="row">
	            	<div class="col-sm-12 portfolio-filters wow fadeInUp">
	            		<a href="#" class="filter-all active">All</a> / 
	            		<a href="#" class="filter-design">Design</a> / 
	            		<a href="#" class="filter-development">Development</a> / 
	            		<a href="#" class="filter-branding">Branding</a>
	            	</div>
	            </div>
	            <div class="row">
	            	<div class="col-sm-12 portfolio-masonry">
		                <div class="portfolio-box design">
		                	<img src="assets/img/portfolio/1.jpg" alt="" data-at2x="assets/img/portfolio/1.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Trilli Bi template</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box development">
		                	<img src="assets/img/portfolio/2.jpg" alt="" data-at2x="assets/img/portfolio/2.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Sit amet logo</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box branding">
		                	<img src="assets/img/portfolio/3.jpg" alt="" data-at2x="assets/img/portfolio/3.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Aeria app page</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box development">
		                	<img src="assets/img/portfolio/4.jpg" alt="" data-at2x="assets/img/portfolio/4.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Etiam processus dynamicus</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box design">
		                	<img src="assets/img/portfolio/5.jpg" alt="" data-at2x="assets/img/portfolio/5.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>March notare site</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box development">
		                	<img src="assets/img/portfolio/6.jpg" alt="" data-at2x="assets/img/portfolio/6.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Mirum est notare</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box design">
		                	<img src="assets/img/portfolio/7.jpg" alt="" data-at2x="assets/img/portfolio/7.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Celic template</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box development">
		                	<img src="assets/img/portfolio/8.jpg" alt="" data-at2x="assets/img/portfolio/8.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Sit amet logo</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box branding">
		                	<img src="assets/img/portfolio/9.jpg" alt="" data-at2x="assets/img/portfolio/9.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Jalia business</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box design">
		                	<img src="assets/img/portfolio/10.jpg" alt="" data-at2x="assets/img/portfolio/10.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Mirum est notare</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box development">
		                	<img src="assets/img/portfolio/11.jpg" alt="" data-at2x="assets/img/portfolio/11.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Etiam processus social</p>
		                		</div>
		                	</div>
		                </div>
		                <div class="portfolio-box branding">
		                	<img src="assets/img/portfolio/12.jpg" alt="" data-at2x="assets/img/portfolio/12.jpg">
		                	<div class="portfolio-box-text-container">
		                		<div class="portfolio-box-text">
		                			<p>Sit website logo</p>
		                		</div>
		                	</div>
		                </div>
	                </div>
	            </div>
	        </div>
        </div>
        
		Block 2
        <div class="block-2-container section-container section-container-gray">
	        <div class="container">
	            <div class="row">
	            	<div class="col-sm-6 block-2-box block-2-left wow fadeInLeft">
	            		<h3>How we do it?</h3>
	            		<p>
	            			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor 
	            			incididunt ut labore et dolore magna.
	            		</p>
	            		<ul>
	            			<li>
	            				<span aria-hidden="true" class="icon_plus list-icon"></span> Etiam processus dynamicus qui
	            			</li>
	            			<li>
	            				<span aria-hidden="true" class="icon_plus list-icon"></span> Quam nunc putamus Photoshop
	            			</li>
	            			<li>
	            				<span aria-hidden="true" class="icon_plus list-icon"></span> Mutationem consuetudium WordPress
	            			</li>
	            			<li>
	            				<span aria-hidden="true" class="icon_plus list-icon"></span> Exerci tation ullamcorper
	            			</li>
	            		</ul>
	            	</div>
	            	<div class="col-sm-6 block-2-box block-2-right block-2-media wow fadeInUp">
	            		<div class="video-box">
		                    <div class="embed-responsive embed-responsive-16by9">
		                    	<iframe class="embed-responsive-item" src="//player.vimeo.com/video/115014610?title=0&amp;byline=0&amp;portrait=0&amp;badge=0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
		                    </div>
	                    </div>
	            	</div>
	            </div>
	        </div>
        </div> -->

		<!-- Our motto -->
        <div class="our-motto-container section-container section-container-full-bg">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 our-motto section-description wow fadeInLeftBig">
	                    <p>
	                    	"Success is not the key to happiness. Happiness is the key to success. 
	                    	If you love what you are doing, you will be successful."
	                    </p>
	                    <div class="our-motto-author">ALBERT SCHWEITZER</div>
	                </div>
	            </div>
	        </div>
        </div>

       <!-- <!--  Testimonials
        <div class="testimonials-container section-container section-container-gray">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-8 testimonials section-description wow fadeInLeft">
	                    <h3>Listen to our clients</h3>
	                    <div class="testimonial-active"></div>
	                    <div class="testimonial-single">
	                    	<p>
	                    		Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit 
	                    		lobortis nisl ut aliquip ex ea commodo consequat. Ut wisi enim ad minim veniam, 
	                    		quis nostrud exerci tation ullamcorper suscipit lobortis nisl.
	                    		<br>
	                    		<a href="">John Doe, johndoe.com</a>
	                    	</p>
	                    	<div class="testimonial-single-image">
	                    		<img src="assets/img/testimonials/1.jpg" alt="" data-at2x="assets/img/testimonials/1.jpg">
	                    	</div>
	                    </div>
	                    <div class="testimonial-single">
	                    	<p>
	                    		Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt 
	                    		ut labore et. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor 
	                    		incididunt ut labore et.
	                    		<br>
	                    		<a href="">Jane Jonsson, blog.jane.com</a>
	                    	</p>
	                    	<div class="testimonial-single-image">
	                    		<img src="assets/img/testimonials/2.jpg" alt="" data-at2x="assets/img/testimonials/2.jpg">
	                    	</div>
	                    </div>
	                    <div class="testimonial-single">
	                    	<p>
	                    		Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit 
	                    		lobortis nisl ut aliquip ex ea commodo consequat. Ut wisi enim ad minim veniam, 
	                    		quis nostrud exerci tation ullamcorper suscipit lobortis nisl.
	                    		<br>
	                    		<a href="">John Doe, johndoe.com</a>
	                    	</p>
	                    	<div class="testimonial-single-image">
	                    		<img src="assets/img/testimonials/3.jpg" alt="" data-at2x="assets/img/testimonials/3.jpg">
	                    	</div>
	                    </div>
	                    <div class="testimonial-single">
	                    	<p>
	                    		Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt 
	                    		ut labore et. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor 
	                    		incididunt ut labore et.
	                    		<br>
	                    		<a href="">Jane Jonsson, blog.jane.com</a>
	                    	</p>
	                    	<div class="testimonial-single-image">
	                    		<img src="assets/img/testimonials/4.jpg" alt="" data-at2x="assets/img/testimonials/4.jpg">
	                    	</div>
	                    </div>
	                </div>
	            </div>
	            <div class="testimonials-icon-container">
            		<span aria-hidden="true" class="icon_chat"></span>
            	</div>
	        </div>
        </div> --> -->
        
        <!-- About us -->
        <div class="about-container section-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 about section-description wow fadeIn">
	                    <h2>About us</h2>
	                    <div class="divider-1 wow fadeInUp"><span></span></div>
	                    <p>
	                    	Group of graduate students at CSULA ( California State University - Los Angeles) class CS5220, Dr.Sun 
	                    </p>
	                </div>
	            </div>
	        </div>
        </div>
        
        <!-- Block 2 (team member) -->
        <div class="block-2-container section-container about-block-2-container">
	        <div class="container">
	            <div class="row">
	            	<div class="col-sm-4 block-2-box block-2-left block-2-media wow fadeInLeft">
	            		<div class="block-2-img-container">
	            			<img src="assets/img/about/1.jpg" alt="" data-at2x="assets/img/about/1.jpg">
	            			<div class="img-container-line line-1"></div>
	            			<div class="img-container-line line-2"></div>
	            			<div class="img-container-line line-3"></div>
	            		</div>
	            	</div>
	            	<div class="col-sm-8 block-2-box block-2-right wow fadeInUp">
	            		<h3> Member 1 / <span> Our CEO </span></h3>
	            		<p>
	            			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut 
	            			labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
	            		</p>
	            		<p>
	            			Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. 
	            			Mirum est notare quam littera gothica, quam nunc putamus parum claram lorem.
	            		</p>
	            		<h3>Follow Her:</h3>
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
	                	<h2>Login</h2>
	                	<div class="divider-1 wow fadeInUp"><span></span></div>
	                    <p>
	                    	Thank you for being a member in our team
	                    </p>
	                </div>
	            </div>
	            <div class="row">
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
	            </div>
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
                    	&copy;  <a href="http://azmind.com/free-bootstrap-themes-templates/"> Company's name </a>.
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
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
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
 