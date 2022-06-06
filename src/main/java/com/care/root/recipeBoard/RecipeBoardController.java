package com.care.root.recipeBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeBoardController {

	@GetMapping("recipe/recipeBoard")
	public String recipeBoardList() {
		
		return "recipe/recipeBoard";
	}
	
	@GetMapping("recipe/recipeBoardWrite")
	public String recipeBoardWrite() {
		
		return "recipe/recipeBoardWriteForm";
	}
	
	
}
