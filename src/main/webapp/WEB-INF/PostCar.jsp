<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="ISO-8859-1">
    <title>Posting Your Car Information - Biddingya</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Favicon -->
    <link href="../img/favicon.ico" rel="icon" />

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
    <link href="../css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="../css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="../css/admin.css" />
  </head>
<body>
<jsp:include page="My-Header-In.jsp"></jsp:include>
	<!-- post jobs start -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
    <div class="container" style="margin-top: 20px; background: #f8f8f8">
      <div class="row flex-lg-nowrap">
        <div class="col">
          <div class="row">
            <div class="col mb-3">
              <div class="card">
                <div class="card-body">
                  <div class="e-profile">
                    <div class="row">
                      <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                        <div class="text-center text-sm-left mb-2 mb-sm-0">
                          <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap">Vehicle Information</h4>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-content pt-3">
                      <div class="tab-pane active">
                        <sp:form name="job" class="job-form" id="job-form" action="/viewcar" method="POST" modelAttribute="car">
                          <div class="row">
                            <div class="col">
                              <div class="row">
                                <div class="col">
                                  <div class="form-group">
                                    <label for="carModel">Model</label>
                                    <sp:input path="carModel" class="form-control" type="text" id="carModel" name="carModel" />
                                  </div>
                                </div>
                                <div class="col">
                                  <div class="form-group">
                                    <label for="carBodyStyle">Body Style</label>
                                    <sp:input path="carBodyStyle" class="form-control" type="text" id="carBodyStyle" name="carBodyStyle"  />
                                  </div>
                                </div>
                              </div>
                              <div class="row" style="margin-top: 20px;">
                                <div class="col">
                                  <div class="form-group">
                                    <label for="carMake">Make</label>
                                    <sp:input path="carMake" class="form-control" type="text" id="carMake" name="carMake"  />
                                 </div>
                                 </div>
                                 <div class="col">
                                  <div class="form-group">
                                    <label for="carYear">Year</label>
                                    <sp:input path="carYear" class="form-control" type="month" id="carYear" name="carYear"  />
                                  </div>
                                </div>
                                
                              </div>
                              <div class="row" style="margin-top: 20px;">
                                <div class="col">
                                  <div class="form-group">
                                    <label for="carPrice">Price</label>
                                    <sp:input path="carPrice" class="form-control" type="number" id="carPrice" name="carPrice"  />
                                 </div>
                                 </div>
                                 <div class="col">
                                  <div class="form-group">
                                    <label for="carColor">Color</label>
                                    <sp:input path="carColor" class="form-control" type="text" id="carColor" name="carColor"  />
                                  </div>
                                </div>
                              </div>
                               <div class="row" style="margin-top: 20px;">
                                <div class="col">
                                  <div class="form-group">
                                    <label for="carVIN">Vehicle Identification Number(VIN)</label>
                                    <sp:input path="carVIN" class="form-control" type="text" id="carVIN" name="carVIN"  />
                                 </div>
                                 </div>
                              </div>
                              <div class="row" style="margin-top: 20px;">
                                <div class="col mb-3">
                                  <div class="form-group">
                                    <label for="carCondition">The condition of the vehicles</label>
                                    <sp:textarea value="textbox" path="carCondition" class="form-control" id="carCondition" name="carCondition"  rows="5" ></sp:textarea>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col d-flex justify-content-end">
                            <button class="btn btn-primary" id="submit" name="Post">Post</button>
                            </div>
                           
                          </div>
                        </sp:form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- post jobs end  -->
<jsp:include page="Footer-In-Admin.jsp"></jsp:include>

</body>
</html>