package com.care.root;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface KakaoLoginService {
	
	public void registerKakao(Map<String, Object> dto, HttpSession session);
	
	
	
}
