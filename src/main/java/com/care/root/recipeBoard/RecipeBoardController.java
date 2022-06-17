package com.care.root.recipeBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class RecipeBoardController {
	
	@Autowired RecipeBoardService rs;

	@GetMapping("recipe/recipeBoard")
	public String recipeBoardList() {
		
		return "recipe/recipeBoard";
	}
	
	@GetMapping("recipe/recipeBoardWrite")
	public String recipeBoardWrite() {
		
		return "recipe/recipeBoardWriteForm";
	}
	
	@PostMapping("recipe/recipeBoardoneFile")
	public String recipeBoardOneFile(MultipartHttpServletRequest mul) {
		
		System.out.println(mul.getParameter("id"));
		System.out.println(mul.getParameter("title"));
		System.out.println(mul.getParameter("content"));
		MultipartFile file = mul.getFile("image_file_name");
		MultipartFile file1 = mul.getFile("image_file_name2");
		MultipartFile file2 = mul.getFile("image_file_name3");
		System.out.println(file.getOriginalFilename());
		System.out.println(file1.getOriginalFilename());
		System.out.println(file2.getOriginalFilename());
		
		rs.staticFileInput(mul);
		
		return  "redirect:recipeBoard";
	}
	
	
	
}
