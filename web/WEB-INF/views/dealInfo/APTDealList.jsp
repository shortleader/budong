<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"    src="<c:url value='/resources/js/dealInfo/more_list.js'/>"></script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/dealInfo/list_item.css'/>" media="screen" />
	
<meta charset="EUC-KR">
<title>@@@ 아파트  시세  정보  @@@</title>
</head>
<body>
	<div class="contents" align="center">
		도시코드  : ${lawd_cd}		<br>
		검색  년월 : ${deal_ymd}
	
		<table border="1">
			<!-- 테이블 thead 머리말 -->
			<thead>
				<tr>
					<th>No</th>
					<th>건축년도</th>
					<th>년</th>
					<th>법정동</th>
					<th>아파트</th>
					<th>월</th>
					<th>일</th>
					<th>전용면적</th>
					<th>지역코드</th>
					<th>층</th>
					<th>거래금액</th>
				</tr>
			</thead>
			<!-- item list 뿌리기 -->
		<c:choose>
			<c:when test="${!empty list}">
				<c:forEach var="item" items="${list}" varStatus="status">
					<tr id="js-load" class="main">
						<td class="td__item js-load">${status.count }</td>
						<td class="td__item js-load">${item.build_year }</td>
						<td class="td__item js-load">${item.year }</td>
						<td class="td__item js-load">${item.legal_dong }</td>
						<td class="td__item js-load">${item.apartment }</td>
						<td class="td__item js-load">${item.month }</td>
						<td class="td__item js-load">${item.day }</td>
						<td class="td__item js-load">${item.exclusive_area }</td>
						<td class="td__item js-load">${item.area_code }</td>
						<td class="td__item js-load">${item.layer }</td>
						<td class="td__item js-load">${item.transaction_amount }</td>
					</tr>
				</c:forEach>
				<br>
			</c:when>
			<c:otherwise>
					<tr>
						<td align="center" colspan="11">
							정보가  없습니다...
						</td>
					</tr>
			</c:otherwise>
		</c:choose>
		</table>
		
		<br>
   		<div id="js-btn-wrap" class="btn-wrap"> <a href="javascript:;" class="button">더보기</a> </div>
		
		
		<br>
		<a href="realEstate.do">돌아가기</a>
		<br>
		
		<table border="1">
			<!-- 테이블 thead 머리말 -->
			<thead>
				<tr>
					<th>No</th>
					<th>건축년도</th>
					<th>년</th>
					<th>법정동</th>
					<th>아파트</th>
					<th>월</th>
					<th>일</th>
					<th>전용면적</th>
					<th>지역코드</th>
					<th>층</th>
					<th>거래금액</th>
				</tr>
			</thead>
			
			<tr>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
			 				<td>	what's  problem</td>
			 				<td>	what's  problem</td>
			 
			</tr>
			<tr style="display: none">
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
			 	<td>	what's  problem</td>
			 
			</tr>
			<tr style="display: block;">
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
				<td>	what's  problem</td>
			 	<td>	what's  problem</td>
			</tr>
			
		</table>
	</div>
</body>
</html>