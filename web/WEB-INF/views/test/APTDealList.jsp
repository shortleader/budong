<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����Ʈ  �ü�  ����  @@@</title>
</head>
<body>
	<div align="center">
		�����ڵ�  : ${lawd_cd}
		�˻�  ��� : ${deal_ymd}
	
		<table border="1">
			<tr>
				<th>No</th>
				<th>����⵵</th>
				<th>��</th>
				<th>������</th>
				<th>����Ʈ</th>
				<th>��</th>
				<th>��</th>
				<th>�������</th>
				<th>�����ڵ�</th>
				<th>��</th>
				<th>�ŷ��ݾ�</th>
			</tr>
		<c:forEach var="item" items="${list}" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${item.build_year }</td>
				<td>${item.year }</td>
				<td>${item.legal_dong }</td>
				<td>${item.apartment }</td>
				<td>${item.month }</td>
				<td>${item.day }</td>
				<td>${item.exclusive_area }</td>
				<td>${item.area_code }</td>
				<td>${item.layer }</td>
				<td>${item.transaction_amount }</td>
			</tr>
		</c:forEach>
		</table>
	
	<br>
	
	</div>


</body>
</html>