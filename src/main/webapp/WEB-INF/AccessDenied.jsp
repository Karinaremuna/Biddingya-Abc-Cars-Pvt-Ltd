	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Access Denied</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
	</head>
	<style>
	@import url("https://fonts.googleapis.com/css?family=Raleway:400,400i,700");
	
	* {
	  font-family: Raleway, sans-serif;
	}
	
	html,
	body,
	.container {
	  width: 100%;
	  height: 100%;
	  padding: 0;
	  margin: 0;
	}
	
	.container {
	  background: #2f2f2f;
	  display: flex;
	  align-items: center;
	  justify-content: center;
	  flex-wrap: wrap;
	}
	
	.content {
	  margin: 20px;
	}
	
	.mask {
	  display: block;
	  /* animation: mask 1s infinite; */
	  mask-image: url(https://i.postimg.cc/kgBSj8Zz/Masquerade.png);
	  mask-repeat: no-repeat;
	  -webkit-mask-image: url(https://i.postimg.cc/kgBSj8Zz/Masquerade.png);
	  -webkit-mask-repeat: no-repeat;
	}
	
	.text-center {
	  text-align: center;
	}
	
	.color-white-shadow {
	  color: #fff;
	  text-shadow: 0 -1px #0f0f0f;
	}
	
	/*
	@keyframes mask {
	  50% {
	    transform: scale(1.05);
	  }
	}
	*/
	</style>
	<body>
		
		<div class="container">
	  <div class="content">
	
	 <a href="http://localhost:1210/store/get/details"><i class="bi bi-arrow-left" style="color: white"></i></a>
	 
	    <h2 class="color-white-shadow text-center">403 Forbidden<br><small>Access denied</small></h2>
	    <img src="https://images.unsplash.com/photo-1506202687253-52e1b29d3527?ixlib=rb-0.3.5&s=b43d68ed98b673427669234757d85e56&auto=format&fit=crop&w=300&q=80" width="300" height="140" class="mask">
	    <p class="color-white-shadow text-center">You are not allowed to access this page<br> Only admin can access this page.</p>
	  </div>
	</div>
	</body>
	</html>