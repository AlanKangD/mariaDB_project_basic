package com.care.root;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class KakaoLoginServiceImpl implements KakaoLoginService{
	@Autowired KakaoLoginMapper mapper;
	
	@Override
	public void registerKakao(Map<String, Object> dto, HttpSession session) {
		System.out.println("service ");
		System.out.println("sevice" + dto);
		KakaoVO vo = null;
		if(dto != null) {
			
			
			vo = new KakaoVO();
			String nickname = (String)dto.get("nickname");
			String pw = (String)dto.get("profile_image");
			Long id = (Long) dto.get("id");
			System.out.println("service " + nickname);
			System.out.println("service " + pw);
			System.out.println("service " + dto.get("id").getClass());
			System.out.println(id);
			vo.setId(id);
			vo.setNickname(nickname);
			vo.setPw(pw);
			session.setAttribute("kakao", id);
			KakaoVO idChk = mapper.checkid(id);
			if(idChk.getId() != id)
					mapper.registerKakao(vo);
			
			
		}
		
		else System.out.println("데이터가 존자하지 않습니다");
		
	
		
	}
	
	

}
