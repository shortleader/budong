<%@ page import="com.budong.R" %><%--
  Created by IntelliJ IDEA.
  User: S401-28
  Date: 2018-11-08
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title></title>
</head>
<body>
	메롱메롱
	<a href="<%=R.requestToHost(R.controller.real_estate_deal_info, R.mapping.apartment_deal_info)%>">김준영/ 아파트 매매정보 보기</a>

	<!--ljy-->
	<div align="center">
		<a href="<%=R.requestToHost(R.mapping.chat_home)%>">채팅 바로가기</a>
	</div>

</body>
</html>
