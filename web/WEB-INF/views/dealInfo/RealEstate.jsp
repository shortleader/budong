<%@ page import="com.budong.R" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>테스트 정보</title>
    <script type="text/javascript" src="<c:url value='/resources/js/dealInfo/raphael_min.js'/>"></script>
    <script src="<c:url value='/resources/js/dealInfo/seoul-local.js'/>" type="text/javascript" charset="UTF-8"></script>

    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/dealInfo/local.css'/>"/>

</head>
<body>
<div align="center">

    <form name="f" id="submitButton" method="get"
          action="<%=R.requestToHost(R.controller.real_estate_deal_info,R.mapping.apartment_deal_info)%>">

        <div class="mapArea">
            <div id="locName"></div>
            <div id="paper"></div>
        </div>

        <br><br>

        <div>지역 : <input type="hidden" name="lawd_cd" value="11110"></div>
        <div>
            <label for="deal_ymd">
                기간 :
                <input id="deal_ymd" type="month" name="deal_ymd">
            </label>
        </div>

        <input type="submit" value="ok">

    </form>

</div>
</body>
</html>