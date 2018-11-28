<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
	<div align="center">
		<form method="post" action="login.do">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mem_id"></td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mem_pw"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="로그인"></td>
				</tr>

			</table>

		</form>

	</div>
</body>
</html>