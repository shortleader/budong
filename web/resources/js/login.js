/**
 * 로그인 자바스크립트
 */

// LOGIN TABS
$(function() {
	var tab = $('.tabs h3 a');
	tab.on('click', function(event) {
		event.preventDefault();
		tab.removeClass('active');
		$(this).addClass('active');
		tab_content = $(this).attr('href');
		$('div[id$="tab-content"]').removeClass('active');
		$(tab_content).addClass('active');
	});
});

// SLIDESHOW
$(function() {
	$('#slideshow > div:gt(0)').hide();
	setInterval(function() {
		$('#slideshow > div:first').fadeOut(1000).next().fadeIn(1000).end()
				.appendTo('#slideshow');
	}, 3850);
});

// CUSTOM JQUERY FUNCTION FOR SWAPPING CLASSES
(function($) {
	'use strict';
	$.fn.swapClass = function(remove, add) {
		this.removeClass(remove).addClass(add);
		return this;
	};
}(jQuery));

// SHOW/HIDE PANEL ROUTINE (needs better methods)
// I'll optimize when time permits.
$(function() {
	$('.agree,.forgot, #toggle-terms, .log-in, .sign-up')
			.on(
					'click',
					function(event) {
						event.preventDefault();
						var terms = $('.terms'), recovery = $('.recovery'), close = $('#toggle-terms'), arrow = $('.tabs-content .fa');
						if ($(this).hasClass('agree')
								|| $(this).hasClass('log-in')
								|| ($(this).is('#toggle-terms'))
								&& terms.hasClass('open')) {
							if (terms.hasClass('open')) {
								terms.swapClass('open', 'closed');
								close.swapClass('open', 'closed');
								arrow.swapClass('active', 'inactive');
							} else {
								if ($(this).hasClass('log-in')) {
									return;
								}
								terms.swapClass('closed', 'open').scrollTop(0);
								close.swapClass('closed', 'open');
								arrow.swapClass('inactive', 'active');
							}
						} else if ($(this).hasClass('forgot')
								|| $(this).hasClass('sign-up')
								|| $(this).is('#toggle-terms')) {
							if (recovery.hasClass('open')) {
								recovery.swapClass('open', 'closed');
								close.swapClass('open', 'closed');
								arrow.swapClass('active', 'inactive');
							} else {
								if ($(this).hasClass('sign-up')) {
									return;
								}
								recovery.swapClass('closed', 'open');
								close.swapClass('closed', 'open');
								arrow.swapClass('inactive', 'active');
							}
						}
					});
});

// DISPLAY MSSG
// 닫기버튼
$(function() {
	$('.recovery .button').on('click', function(event) {
		event.preventDefault();
		v
		$('.recovery .mssg').addClass('animate');

		setTimeout(function() {
			$('.recovery').swapClass('open', 'closed');
			$('#toggle-terms').swapClass('open', 'closed');
			console.log('settimeout');
			$('.tabs-content .fa').swapClass('active', 'inactive');
			$('.recovery .mssg').removeClass('animate');
		}, 5000);

	});
});

// select box
$(function() {
	$('#nights').click(function() {
		$('#night_option').toggle();
	});

	$('.option').click(
			function() {
				$('.select_text').html($(this).attr('id'));
				$('#nightselect option[value=' + $(this).attr('id') + ']')
						.prop('selected', true);
				$('#night_option').toggle();
			});
});

// 프로필 이미지 등록
$(function() {

	// 파일 업로드 창 띄우기
	$('.avatar-preview').click(function() {
		console.log('hi');
		$('#imageUpload').click();
	});

	// 이미지 파일이 선택되면 경로를 읽어온다.
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#imagePreview').css('background-image',
						'url(' + e.target.result + ')');
				$('#imagePreview').hide();
				$('#imagePreview').fadeIn(650);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imageUpload").change(function() {
		readURL(this);
	});
});

// 회원가입 
$(function() {

	// 아이디 유효성 검사
	function validateId(id) {
		// 대소문자,숫자 5~15자리
		var idPatteren = /^[a-z0-9]{5,15}$/;
		if (idPatteren.test(id)) {
			return true;
		} else {
			return false;
		}
	}

	// 비밀번호 유효성 검사
	function validatePw(pw) {
		// 대소문자,숫자 5~10자리
		var pwPattern = /^[A-Za-z0-9]{5,10}$/;
		if (pwPattern.test(pw)) {
			return true;
		} else {
			return false;
		}
	}


	function onIdChanged(id, avail) {
		console.log("결과 : " + avail);
		
		console.log(avail=='valid'); 
		console.log("validation : "+!validateId(id));
		if (avail == 'valid') { //사용가능한 아이디 
			if (validateId(id)) {
				$('#id-validation').css('color', '#4FDA8C');
				$('#id-validation').html('사용가능한 아이디 입니다.');
				$('#user_id').css('border-bottom', '1px solid #4FDA8C');
			} else { //사용가능한 아이디인데 유효성 검사 만족 못한 경우 
				$('#id-validation').css('color', 'rgb(255,49,0)');
				$('#id-validation').html('5~15자의 영문 소문자, 숫자만 사용가능합니다.');
				$('#user_id').css('border-bottom', '1px solid rgb(255,49,0)');
			}
		} else { //아이디 중복
			$('#id-validation').css('color', 'rgb(255,49,0)');
			$('#id-validation').html('이미 존재하는 아이디입니다.');
			$('#user_id').css('border-bottom', '1px solid rgb(255,49,0)');
		}
	}
	
	//DB에 중복되는 아이디 있는지 검사한다. 		
	$('#user_id').on('change blur', function() {
		console.log('check');
		var id =  $('#user_id').val();
		$.ajax({
			type : 'POST',
			data : {
				"id" : id
			},
			url : "checkId.do",
			success : function(data) {
				console.log(data);
				onIdChanged(id, data);
			},
			error : function(data) {
				console.warn("Server Error");
				onIdChanged(id, data);
			}
		});
	});

	// 이름 유효성 검사
	$('#user_name').on('change blur', function() {
		var name = $('#user_name').val();
		if (name.length == 0) {
			$('#name-validation').css('color', 'rgb(255, 49, 0)');
			$('#name-validation').html('이름을 입력해주세요');
			$('#user_name').css('border-bottom', '1px solid rgb(255, 49, 0)');

		} else {
			$('#name-validation').css('color', '#4FDA8C');
			$('#name-validation').html('');
			$('#user_name').css('border-bottom', '1px solid #4FDA8C');
		}
	});

	// 비밀번호 유효성 검사
	$('#user_pass').on('change blur', function() {
		var pass = $('#user_pass').val();
		if (!validatePw(pass) || pass.length == 0) {
			$('#pw-validation').css('color', 'rgb(255, 49, 0)');
			$('#pw-validation').html('5~10자의 영문 대소문자,숫자만 사용가능합니다.');
			$('#user_pass').css('border-bottom', '1px solid rgb(255, 49, 0)');
		} else {
			$('#pw-validation').css('color', '#4FDA8C');
			$('#pw-validation').html('사용가능한 비밀번호 입니다.');
			$('#user_pass').css('border-bottom', '1px solid #4FDA8C');
		}

	});

	$('#sign-up-btn').click(
			function(evt) {
				var id = $('#user_id').val();
				var pw = $('#user_pass').val();
				var name = $('#user_name').val();

				if (!validateId(id) || id.length == 0 || !validatePw(pw)
						|| pw.length == 0 || name.length == 0) {
					evt.preventDefault();
					alert('회원가입 폼을 확인해주세요!');
				} else {
					$('form[name="signUpForm"]').submit();
					console.log('login');
				}
			});

});

// 로그인 유효성 검사
$(function() {

	// 로그인 아이디 검사
	$('#mem_id').on('change blur', function() {
		var mem_id = $('#mem_id').val();
		if (mem_id == "" || mem_id.length == 0) {
			$('#login-id-validation').css('color', 'red');
			$('#login-id-validation').html('아이디를 입력해주세요.');
			$('#mem_id').css('border-bottom', '1px solid rgb(255, 49, 0)');
		} else {
			$('#login-id-validation').css('color', 'green');
			$('#login-id-validation').html('');
			$('#mem_id').css('border-bottom', '1px solid #5A6374');
		}
	});

	// 로그인 비밀번호 검사
	$('#mem_pw').on('change blur', function() {
		var mem_pw = $('#mem_pw').val();
		if (mem_pw == null || mem_pw == "") {
			$('#login-pw-validation').css('color', 'red');
			$('#login-pw-validation').html('비밀번호를 입력해주세요.');
			$('#mem_pw').css('border-bottom', '1px solid rgb(255, 49, 0)');
		} else {
			$('#login-pw-validation').css('color', 'transparent');
			$('#login-pw-validation').html('');
			$('#mem_pw').css('border-bottom', '1px solid #5A6374');
		}
	});

	$('#login-btn').click(function(evt) {
		var mem_id = $('#mem_id').val();
		var mem_pw = $('#mem_pw').val();
		if (mem_id == null || mem_id == "" || mem_pw == null || mem_pw == "") {
			evt.preventDefault();
			alert('로그인 폼을 확인해주세요');
		} else {
			$('form[name="loginForm"]').submit();
		}
	});

});