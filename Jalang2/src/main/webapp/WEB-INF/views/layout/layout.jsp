<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<tiles:insertAttribute name="asset"/>
<style>


</style>
</head>
<body class="index-page bg-gray-200">

	
	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="content"/>

	<tiles:insertAttribute name="footer"/>

	<tiles:insertAttribute name="jsasset"/>
	<script type="text/javascript">

	  if (document.getElementById('state1')) {
	    const countUp = new CountUp('state1', document.getElementById("state1").getAttribute("countTo"));
	    if (!countUp.error) {
	      countUp.start();
	    } else {
	      console.error(countUp.error);
	    }
	  }
	  if (document.getElementById('state2')) {
	    const countUp1 = new CountUp('state2', document.getElementById("state2").getAttribute("countTo"));
	    if (!countUp1.error) {
	      countUp1.start();
	    } else {
	      console.error(countUp1.error);
	    }
	  }
	  if (document.getElementById('state3')) {
	    const countUp2 = new CountUp('state3', document.getElementById("state3").getAttribute("countTo"));
	    if (!countUp2.error) {
	      countUp2.start();
	    } else {
	      console.error(countUp2.error);
	    };
	  }
	</script>
	<script>


	</script>

</body>
</html>