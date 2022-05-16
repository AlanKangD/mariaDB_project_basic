<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
	window.Kakao.init("332d92e9a0d5c0d69fe0b4ee95672a83");
	
	/*
	function loginWithKakao() {
	    window.Kakao.Auth.authorize({
	      redirectUri: 'http://localhost:8086/index',
	      scope: 'profile_nickname, profile_image, account_email',
	      success: function(authObj) {
	    	  console.log(authObj);
	    	  window.Kakao.API.reuqest({
	    		  url:'/v2/user/me',
	    		  success : res => {
	    			  const kakao_acount = res.kakao_account;
	    		 	  console.log(kakao_account);
	    		 	  
	    		  }
	    	  })
	      }
	 
	    	
	    })
	  }
	*/
	function loginWithKakao() {
	    Kakao.Auth.login({
	      success: function (response) {
	        Kakao.API.request({
	          url: '/v2/user/me',
	          success: function (response) {
	        	  console.log(response)
	        	  console.log(response.kakao_account)
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
	/*
	
	function loginWithKakao() {
	    window.Kakao.Auth.authorize({
	      scope : 'profile_nickname, profile_image, account_email',
	      success : function(authObj) {
	    	  console.log(authObj);
	    	  window.Kakao.API.reuqest({
	    		  url:'/v2/user/me',
	    		  success : res => {
	    			  const kakao_acount = res.kakao_account;
	    		 	  console.log(kakao_account);
	    		 	  alert(kakao_account);
	    		  }
	    	  });
	      }
	    });
	  }
	*/
	 
	  
	
</script>


</head>
<body>

	<h1>카카오 로그인 테스트!</h1>

	<a id="custom-login-btn" href="javascript:loginWithKakao()"> 
		<img src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
	</a>
	<p id="token-result"></p>


</body>
</html>