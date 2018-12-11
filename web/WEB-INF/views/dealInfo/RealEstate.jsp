<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>테스트  정보</title>
	<script type="text/javascript" src="<c:url value='/resources/js/dealInfo/raphael_min.js'/>"></script>
	<script src="//code.jquery.com/jquery-1.9.1.js"></script>
	<script src="<c:url value='/resources/js/dealInfo/seoul-local.js'/>" type="text/javascript" charset="UTF-8"></script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/dealInfo/local.css'/>" />
	
</head>
<body>
	<div align="center">
	
		<form name="f" method="post" action="apt_dealInfo.do">
			
			<div class="mapArea">
			    <div id="locName"></div>
			    <div id="paper"></div>
			</div>
			
			<br><br>
						
			지역  : <input type="text" name="lawd_name" value="금천구" >
			
			<br/>
			기간  : <input type="month" name="deal_ymd">	<br/>
			
			<input type="submit" value="ok">
			
		</form>
	</div>
</body>
</html>