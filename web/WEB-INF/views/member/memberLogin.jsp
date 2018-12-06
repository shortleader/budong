<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<link href='<c:url value="/resources/css/login.css" />' rel="stylesheet">
<script src="<c:url value="/resources/js/login.js" />"></script>
</head>
<body>
	<!-- LOGIN MODULE -->
	<div class="login">
		<div class="wrap">
			<!-- TOGGLE -->
			<div id="toggle-wrap">
				<div id="toggle-terms">
					<div id="cross">
						<span></span> <span></span>
					</div>
				</div>
			</div>
			<!-- TERMS -->

			<!-- RECOVERY -->
			<div class="recovery">
				<h2>Password Recovery</h2>
				<p>
					Enter either the <strong>email address</strong> or <strong>username</strong>
					on the account and <strong>click Submit</strong>
				</p>
				<p>We'll email instructions on how to reset your password.</p>
				<form class="recovery-form" action="" method="post">
					<input type="text" class="input" id="user_recover"
						placeholder="Enter Email or Username Here"> <input
						type="submit" class="button" value="Submit">
				</form>
				<p class="mssg">An email has been sent to you with further
					instructions.</p>
			</div>

			<!-- SLIDER -->
			<div class="content">
				<!-- SLIDESHOW -->
				<div id="slideshow">
					<div class="one"></div>
					<div class="two">
						<h2>
							<span>Budong</span>
						</h2>
					</div>
					<div class="three">
						<h2>
							<span>Budong</span>
						</h2>
					</div>
					<div class="four">
						<h2>
							<span>Budong</span>
						</h2>
					</div>
				</div>
			</div>

			<!-- LOGIN FORM -->
			<div class="user">
				<!-- ACTIONS
                    <div class="actions">
                        <a class="help" href="#signup-tab-content">Sign Up</a><a class="faq" href="#login-tab-content">Login</a>
                    </div>
                    -->
				<div class="form-wrap">
					<!-- TABS -->
					<div class="tabs">
						<h3 class="login-tab">
							<a class="log-in active" href="#login-tab-content"><span>Login<span></a>
						</h3>
						<h3 class="signup-tab">
							<a class="sign-up" href="#signup-tab-content"><span>Sign
									Up</span></a>
						</h3>
					</div>
					<!-- TABS CONTENT -->
					<div class="tabs-content">
						<!-- TABS CONTENT LOGIN -->
						<div id="login-tab-content" class="active">
							<!-- 로그인 폼  -->

							<form id="myform" name="loginForm" class="login-form"
								method="post" action="login.do">
								<input type="text" class="input" id="mem_id" name="mem_id"
									autocomplete="off" placeholder="Username">
								<p id="login-id-validation" class="validation-text">유효하지 않습니다</p>
								<input type="password" class="input" name="mem_pw" id="mem_pw"
									autocomplete="off" placeholder="Password">
								<p id="login-pw-validation" class="validation-text">유효하지 않습니다</p>
								<!-- <input type="checkbox" class="checkbox" checked id="remember_me"
									name="useCookie" value="true"> <label for="remember_me">Remember
									me </label> --> <input type="submit" id="login-btn" class="button"
									value="Login">
							</form>

							<div class="help-action">
								<p>
									<i class="fa fa-arrow-left" aria-hidden="true"></i><a
										class="forgot" href="#">Forgot your password?</a>
								</p>
							</div>
						</div>

						<!--회원가입 탭  -->
						<div id="signup-tab-content">

							<form class="signup-form" name="signUpForm"
								action="insertMember.do" method="post"
								enctype="multipart/form-data">
								<!--프로필 이미지  -->
								<div class="img-container">
									<div class="avatar-upload">
										<div class="avatar-edit">
											<input type='file' id="imageUpload" name="mem_img"
												accept=".png, .jpg, .jpeg" />
										</div>

										<div class="avatar-preview">
											<div id="imagePreview"
												style="background-image: url(<c:url value="/resources/images/camera.png" />);">
											</div>
										</div>
									</div>
								</div>


								<input type="text" class="input" id="user_id" name="mem_id"
									autocomplete="off" placeholder="ID">
								<p id="id-validation" class="validation-text">유효하지 않습니다</p>
								<input type="text" class="input" id="user_name" name="mem_name"
									autocomplete="off" placeholder="Username">
								<p id="name-validation" class="validation-text">유효하지 않습니다</p>
								<input type="password" class="input" id="user_pass"
									name="mem_pw" autocomplete="off" placeholder="Password">
								<p id="pw-validation" class="validation-text">유효하지 않습니다</p>

								<!--select box  -->
								<div class="column-6 form-select">
									<select name="mem_region" class="select-box-region">
										<option value="" disabled="disabled" selected="selected">거주
											지역을 선택해 주세요</option>
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
									</select>
								</div>

								<input type="submit" class="button" id="sign-up-btn"
									value="Sign Up">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>