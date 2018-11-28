<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css"
	rel="stylesheet" type='text/css'>
<link href='<c:url value="/resources/css/chat.css" />' rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>

<script>
	function setMyChatImg() {
		document.head.innerHTML = document.head.innerHTML
				+ '<style> .messages li.other:before { right: -45px; background-image: url(/budong-info/resources/images/${userImg});} </style>'
	}

	$(function() {

		$("#dialog").dialog({
			autoOpen : false,
			modal : true
		});

		$("#loginBtn").on("click", function(e) {
			e.preventDefault();
			$("#dialog").dialog("open");
		});

	});
</script>
</head>
<body>

	<div align="center">
		<%
			if (session.getAttribute("userId") != null) {
		%>
		<input type="button" value="로그아웃" onClick="location.href='logout.do'" />
		<c:set var="userId" value="${userId}" />
		<c:set var="userImg" value="${userImg}" />

		<!--로그인 팝업 모달  -->
		<div class="modal">this is a modal pop up</div>

		<!-- 채팅 버튼  -->
		<div class="floating-chat">
			<i class="fa fa-comments" aria-hidden="true"></i>
			<div class="chat">
				<!-- 채팅 헤더  -->
				<div class="header">
					<span class="title"> Budong Chat</span>
					<button>
						<i class="fa fa-times" aria-hidden="true"></i>
					</button>
				</div>
				<!-- 	<ul class="messages"> -->
				<!-- 채팅 내용  -->
				<ul class="chat-history">
					<!-- 				<li class="clearfix">
					<div class="message-data align-right">
						<span class="message-data-time"> 10:27 PM</span> &nbsp; &nbsp; <span
							class="message-data-name"> Gildong</span>
					</div>

					<div class="message my-message float-right">Message Test...</div>
				</li>

				<li>
					<div class="message-data">
						<span class="message-data-name"> Vincent</span> <span
							class="message-data-time">10:12 AM, Today</span>
					</div>
					<div class="message other-message">Are we meeting today?
						Project has been already finished and I have results to show you.</div>
				</li> -->

				</ul>
				<!--메시지 전송 부분  -->
				<div class="footer clearfix">
					<div class="text-box" contenteditable="true" class="single-line"
						disabled="true"></div>
					<button id="sendMessage">send</button>
				</div>
			</div>
		</div>
		<%
			} else {
		%>
		<input type="button" value="로그인" id="loginBtn" />

		<!--로그인/회원가입 팝업 -->
		<div id="dialog">
			<c:import url="/loginHome.do" charEncoding="UTF-8" />
		</div>

		<%
			}
		%>
	</div>

	<script type="text/javascript">
		var webSocket = new WebSocket('ws://localhost:8080/chat/chatting');
		webSocket.onerror = function(event) {
			onError(event)
		};

		webSocket.onopen = function(event) {
			onOpen(event)
		};

		webSocket.onmessage = function(event) {
			onMessage(event)
		};

		//상대방에게서 메시지 받음 
		function onMessage(event) {
			console.log(event.data);

			//JSON 받아서 파싱 
			var msg = JSON.parse(event.data);
			/* 	var img = "/budong-info/resources/images/" + msg.img; */
			var messagesContainer = $('.chat-history');

			messagesContainer
					.append([
							'<li> <div class="message-data"> <span class="message-data-name">',
							msg.id,
							'</span> <span class="message-data-time">',
							msg.date,
							'</span> </div> <div class="message other-message">',
							msg.text, '</div> </li>' ].join(''));

			messagesContainer.finish().animate({
				scrollTop : messagesContainer.prop("scrollHeight")
			}, 250);

		}

		/* 	function setOtherChatImg(img) {
				//상대방 메시지 사진 설정  
				console.log(img);
				$('.messages li.self:before').attr('style',
						'background-image: url("' + img + '")');
			} */

		function onOpen(event) {
		}

		function onError(event) {
			alert(event.data);
		}

		//메시지 전송 
		function send() {
			var userInput = $('.text-box');
			var newMessage = userInput.html().replace(/\<div\>|\<br.*?\>/ig,
					'\n').replace(/\<\/div\>/g, '').trim().replace(/\n/g,
					'<br>');

			if (!newMessage)
				return;

			var messagesContainer = $('.chat-history');

			//아이디, 프로필이미지, 채팅내용을 JSON에 넣음 			
			var d = new Date();
			var msg = {
				id : "${userId}",
				img : "${userImg}",
				text : newMessage,
				date : d.toLocaleString()
			}

			messagesContainer
					.append([
							'<li class="clearfix"> <div class="message-data align-right"> <span class="message-data-time">',
							msg.date,
							'</span>  &nbsp; <span class="message-data-name">',
							msg.id,
							'</span> </div> <div class="message my-message float-right">',
							msg.text, '</div> </li>' ].join(''));

			// clean out old message
			userInput.html('');
			// focus on input
			userInput.focus();

			messagesContainer.finish().animate({
				scrollTop : messagesContainer.prop("scrollHeight")
			}, 250);

			webSocket.send(JSON.stringify(msg));
			userInput.value = "";
		}
	</script>

	<script>
		var element = $('.floating-chat');
		var myStorage = localStorage;

		setTimeout(function() {
			element.addClass('enter');
		}, 1000);

		element.click(openElement);

		function openElement() {
			var messages = element.find('.messages');
			var textInput = element.find('.text-box');
			element.find('>i').hide();
			element.addClass('expand');
			element.find('.chat').addClass('chat-enter');
			/* 			element.find('.other').pseudostyle("before", "background-image", "${userImg}"); */
			/* var strLength = textInput.val().length * 2; */
			/* 			element.find('head').append('<style> .messages li.other:before { right: -45px; background-image: url(${userImg});} </style>');  */

			textInput.keydown(onMetaAndEnter).prop("disabled", false).focus();
			element.off('click', openElement);
			element.find('.header button').click(closeElement); //닫기버튼 
			element.find('#sendMessage').click(send); //전송버튼
			messages.scrollTop(messages.prop("scrollHeight"));
		}

		function closeElement() {
			element.find('.chat').removeClass('chat-enter').hide();
			element.find('>i').show();
			element.removeClass('expand');
			element.find('.header button').off('click', closeElement);
			element.find('#sendMessage').off('click', send);
			element.find('.text-box').off('keydown', onMetaAndEnter).prop(
					"disabled", true).blur();
			setTimeout(function() {
				element.find('.chat').removeClass('chat-enter').show()
				element.click(openElement);
			}, 500);
		}

		function onMetaAndEnter(event) {
			if (event.keyCode == 13) {
				send();
			}
		}
	</script>
</html>