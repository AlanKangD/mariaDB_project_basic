<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- jquery를 사용할 때 소스 -->
<script type="text/javascript">
	var email = '';

	window.Kakao.init("332d92e9a0d5c0d69fe0b4ee95672a83");
	
	function loginWithKakao() {
	    Kakao.Auth.login({
	      success: function (response) {
	        Kakao.API.request({
	          url: '/v2/user/me',
	          success: function (response) {
	        	  console.log(response)
	        	  console.log(response.id)
	        	  console.log(response.kakao_account)
	        	  console.log('decode email : ' + response.kakao_account.email)
	        	  console.log(response.kakao_account.profile)
	        	  console.log(response.kakao_account.profile['nickname'])
	        	  console.log(response.kakao_account.profile['profile_image_url'])
	        	 var form = {nickname : response.kakao_account.profile['nickname'] ,
	        		  				profile_image : response.kakao_account.profile['profile_image_url'],
	        		  					id : response.id}
	        	 console.log(form)
	        	  
	        	  ajax(form);
	        	 
	        	  
     	  
	        	 // location.href="/kakao/kakaoLoginSucess";  로그인 처리되면 해당 경로로 이동시킴
	        	/*
	        	 if(response != null) {
	        		$("#kakaoLoginForm").hide();
	        	}
	        	*/
	          },
	          fail: function (error) {
	            console.log(error)
	          },
	        })
	      },
	      fail: function (error) {
	        console.log(error)
	      },
	    })
	  }
	
	function logoutFun() {
		 if (!Kakao.Auth.getAccessToken()) {
		      alert('Not logged in.')
		      return
		    }
		    Kakao.Auth.logout(function() {
		    	$.ajax({
		    		url : "kakao/logoutFun",
		    		type : "get",
		    		success : function(data) {
		    			console.log('성공')
		    			alert('성공')
		    		}, error : function(){
		    			alert('실패')
		    		}
		    		
		    	})
		      alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken())
		    })
		  }
	
	
	
	function ajax(form) {
		  $.ajax({
			  url : "kakao/loginFun",
			  type : "post", 
			  data : JSON.stringify(form),
			  datatype : 'json',
		  	  contentType : "application/json; charset=utf-8",
		  	  success : function(result) { 
		  		  console.log('성공')
		  		  console.log(result.result)
		  		  if(result.result == 1) {
		  			  console.log('result == 1')
		  			  location.href='kakao/kakaoLoginSucess';
		  		  }
		  		  
		  	  },
		  	  error : function(){
		  		  console.log('실패')
		  	  }
			  
			  
		  })
	  }
</script>


</head>
<body>

	<h1>카카오 로그인 테스트!</h1>
<div id="kakaoLoginForm">
	<a id="custom-login-btn" href="javascript:loginWithKakao()"> 
		<img src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
	</a>
</div>
<%
	Long id = (Long) session.getAttribute("kakao");
%>
<h3>session : </h3> <%=id %>

<button id="kakaologout" onclick="javascript:logoutFun()" >
		로그아웃
</button>


</body>
</html>