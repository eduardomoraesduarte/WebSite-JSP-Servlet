<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="/publica/publica-nav.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="text-center"> 
  <img src="${pageContext.request.contextPath}/resources/images/home.jpg" 
       alt="Feliz Ano Novo" 
       class="img-fluid" 
       style="max-width: 700px;" />
</div>
		</div>

	</div>

</body>
</html>