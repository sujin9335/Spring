<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<link rel="stylesheet" href="/code/resources/highlight/styles/default.min.css">
<style>
	table > tr:nth-child(1) th {
		width: 120px;
	}
	table > tr:nth-child(1) td {
		width: 263px;
	}
	
	#code {
		margin: 1rem;
		border: 1px solid #CCC;
	}
	
	#code * {
		font-family: consolas;
	}

</style>
</head>
<body>
	<h1>Code <small>view</small></map></h1>
	<table>
		<tr>
			<th>번호</th>
			<th>${dto.seq }</th>
			<th>날짜</th>
			<th>${dto.regdate }</th>
		</tr>
		
	
	</table>
	
	<pre id="code"><code class="language-${dto.language }"><c:out value="${dto.code }"></c:out></code></pre>
	
	
	<div>
		<button type="button" class="back" onclick="location.href='/code/list.do';">돌아가기</button>
	</div>


	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="/code/resources/highlight/highlight.min.js"></script>
	<script>
		hljs.highlightAll();

	</script>

</body>
</html>