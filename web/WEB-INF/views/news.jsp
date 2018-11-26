<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside id="test">
<div>
	<b><a href="#" onclick="test((${param.param}-1))"> << </a> &nbsp;&nbsp;${param.param}&nbsp;&nbsp; <a href="#" onclick="test((${param.param}+1))"> >></a></b>   
</div>
<c:forEach var="item" items="${list}">
<img src="${item.img}"><a href="#" onclick="test2('${item.url}')">${item.title}</a><br>
<%-- <a href="<%=request.getContextPath()%>/news?url=${item.url}"> --%>
${item.content}<br><br>
</c:forEach>


</aside>