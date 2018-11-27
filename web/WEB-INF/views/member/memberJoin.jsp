<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>

	<div align="center">
		<form name="f" method="post" action="insertMember.do"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mem_id" /></td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="mem_pw" /></td>
				</tr>
				<!-- 	<tr>
					<td>비밀번호 확인</td>
					<td><input type="text" name="mem_pw_check" /></td>
				</tr> -->
				<tr>
					<td>이름</td>
					<td><input type="text" name="mem_name" /></td>
				</tr>

				<tr>
					<td>프로필 사진</td>
					<td><input type="file" name="mem_img" /></td>
				</tr>

				<tr>
					<td>거주 지역</td>
					<td><select name="mem_region">
							<option value="seoul">서울시</option>
							<option value="kyeongki">경기도</option>
							<option value="incheon">인천시</option>
							<option value="busan">부산시</option>
							<option value="daejeon">대전시</option>
							<option value="daegu">대구시</option>
							<option value="ulsan">울산시</option>
							<option value="saejong">세종시</option>
							<option value="kwangju">광주시</option>
							<option value="kangwon">강원도</option>
							<option value="chungbuk">충청북도</option>
							<option value="chungname">충청남도</option>
							<option value="kyungbuk">경상북도</option>
							<option value="kyungnam">경상남도</option>
							<option value="jeonbuk">전라북도</option>
							<option value="jeonnam">전라남도</option>
							<option value="jeju">제주도</option>
					</select></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="가입하기"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>