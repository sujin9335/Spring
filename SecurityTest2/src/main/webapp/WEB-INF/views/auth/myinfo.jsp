<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>


</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	<h2>MyInfo page<small>내 정보</small></h2>
	
	<!--  
		property="principal"
		- CustomerUser 객체
	
	-->
	<div class="message" title="principal">
		<sec:authentication property="principal"/>
	</div>
	
	

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>


	</script>

</body>
</html>