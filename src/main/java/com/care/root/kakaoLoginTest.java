package com.care.root;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class kakaoLoginTest {
	
	@ResponseBody
	@PostMapping(value="kakao/loginFun", produces="application/json; charset=utf-8")
	public String kakaoTest(@RequestBody Map<String, Object> dto) {
		System.out.println("값들어오는 지를 확인 : " + dto);
		
		return "";
	}
}
