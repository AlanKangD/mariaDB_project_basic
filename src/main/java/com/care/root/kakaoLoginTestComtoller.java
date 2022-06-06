package com.care.root;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.care.root.mybatis.KakaoService;

@Controller
public class kakaoLoginTestComtoller {
	@Autowired KakaoLoginService ks;
	
	@ResponseBody
	@PostMapping(value="kakao/loginFun", produces="application/json; charset=utf-8")
	public String kakaoTest(@RequestBody Map<String, Object> dto, HttpSession session) {
		System.out.println("값들어오는 지를 확인 : " + dto);
		
		
		ks.registerKakao(dto, session);
		
		
		return "{\"result\":1}";
	}
	
	@GetMapping("kakao/kakaoLoginSucess")
	public String kakaoLoginSucc() {
		return "kakao/kakaoLoginSucess";
	}
	
	@ResponseBody
	@GetMapping("kakao/logoutFun")
	public String kakaoLogout(HttpSession session) {
		
		session.invalidate();
		return "성공";
	}
	
}
