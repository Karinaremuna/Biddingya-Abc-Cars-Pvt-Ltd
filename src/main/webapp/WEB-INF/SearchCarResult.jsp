<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Search Car Result - Biddingya</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon" />

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;600&family=Teko:wght@400;500;600&display=swap" rel="stylesheet" />

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet" />
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="../css/styles.css" rel="stylesheet" />
  </head>
<body>
<jsp:include page="My-Header-In.jsp"></jsp:include>

 <!-- view job start -->
 <dd:if test="${empty searchcar}">
<style>
  
.page_404{ padding:40px 0; background:#fff; font-family: 'Arvo', serif;
}

.page_404  img{ width:100%;}

.four_zero_four_bg{
 
 background-image: url(https://cdn.dribbble.com/users/285475/screenshots/2083086/dribbble_1.gif);
    height: 400px;
    background-position: center;
 }
 
 
 .four_zero_four_bg h1{
 font-size:80px;
 }
 
  .four_zero_four_bg h3{
			 font-size:80px;
			 }
			 
			 .link_404{			 
	color: #fff!important;
    padding: 10px 20px;
    background: #39ac31;
    margin: 20px 0;
    display: inline-block;}
	.contant_box_404{ margin-top:-50px;}
</style>

  <section class="page_404">
	<div class="container">
		<div class="row">	
		<div class="col-sm-12 ">
		<div class="col-sm-10 col-sm-offset-1  text-center">
		<div class="four_zero_four_bg">
			<h1 class="text-center ">404</h1>
		
		
		</div>
		
		<div class="contant_box_404">
		<h3 class="h2">
		Look like you're lost
		</h3>
		
		<p>the page you are looking for not available!</p>
		
		<a href="/viewcar" class="link_404">Go Back </a>
	</div>
		</div>
		</div>
		</div>
	</div>
</section>
 </dd:if>
<dd:if test="${not empty searchcar}"> 
 <button style="margin: 0 0 -20px 248px; height: 35px;" class="btn btn-secondary" ><a href="/searchcar" class="text-white" stlye="text-decoration:none;">Back</a></button>
  <dd:forEach var="car" items="${searchcar}">
      <div>
        <div class="viewjob1" style="height: 250px">
          <div style="display: block; float: left"><img src="../img/rubicon.jpg" style="width: 320px; height: auto; margin: -16px 0 0 -16px" alt="" /></div>
          <div class="vj1">
            <h3 style="margin: 0 0 0 15px" class="display-6 mb-1 m-0"><a style="margin: 0 0 0 20px" class="text-dark" href="/viewcarresultadmin/${car.carId}">${car.carModel}</a></h3>
            <h4 class="display-6 mb-1 text-primary m-0"><a style="margin: 0 0 0 20px" href="/viewcarresultadmin/${car.carId}">${car.carPrice}</a></h4>
            <p><a class="text-muted" style="margin: 0 0 0 20px" href="/viewcarresultadmin/${car.carId}">${car.carYear}</a></p>
            <i class="bi bi-cash-coin text-success" style="font-weight: bold; margin: 0 0 0 0px"> &nbsp;&nbsp;&nbsp; Offer is still open</i>
          </div>
          <div>
            <button type="button" id="submit" name="submit" class="btn btn-success"><a href="/viewcarresult/${car.carId}" style="color: white">Details</a></button>
          </div>
        </div>
      </div>
    </dd:forEach>
    </dd:if>
    
    <!-- view job end  -->
   <div style="margin-top: 500px">
<jsp:include page="My-Footer-In.jsp"></jsp:include>
</div>
<!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>

    <!-- Template Javascript -->
    <script src="../js/main.js"></script>
</body>
</html>