package com.care.root.recipeBoard;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Primary
@Service
public class RecipeBoardServiceImpl implements RecipeBoardService{
	@Autowired StaticFileInputMapper fileMapper;
	@Autowired BoardContentMapper mapper;
	public static final String IMAGE_REPO = "C:/Users/samsung/Desktop/image_repo/test";
	@Override
	public void staticFileInput(MultipartHttpServletRequest mul) {
		
		System.out.println("service" +mul.getParameter("id"));
		System.out.println("service" +mul.getParameter("title"));
		System.out.println("service" +mul.getParameter("content"));
		MultipartFile file = mul.getFile("image_file_name");
		MultipartFile file1 = mul.getFile("image_file_name2");
		MultipartFile file2 = mul.getFile("image_file_name3");
		System.out.println("service" +file.getOriginalFilename());
		System.out.println("service" +file1.getOriginalFilename());
		System.out.println("service" +file2.getOriginalFilename());
		
		BoardContentVO contentVO = new BoardContentVO();
		contentVO.setBoardseq(1);
		contentVO.setId(mul.getParameter("id"));
		contentVO.setTitle(mul.getParameter("title"));
		contentVO.setContent(mul.getParameter("content"));
		mapper.insertContent(contentVO);
		if(file.getSize() != 0 || file1.getSize() != 0 || file2.getSize() != 0) {
			File saveFile = new File(IMAGE_REPO + "/" + file.getOriginalFilename()); //파일의 최종 경로라고 생각하면됩니다.
			File saveFile1 = new File(IMAGE_REPO + "/" + file1.getOriginalFilename()); //파일의 최종 경로라고 생각하면됩니다.
			File saveFile2 = new File(IMAGE_REPO + "/" + file2.getOriginalFilename()); //파일의 최종 경로라고 생각하면됩니다.
			FileInputTestVO fileVO  = new FileInputTestVO();
			try {
				file.transferTo(saveFile); //파일을 저장하는 명령문
				file1.transferTo(saveFile1); //파일을 저장하는 명령문
				file2.transferTo(saveFile2); //파일을 저장하는 명령문
				fileVO.setFileseq(1);
				fileVO.setFile1(file.getOriginalFilename());
				fileVO.setFile2(file1.getOriginalFilename());
				fileVO.setFile3(file2.getOriginalFilename());
				mapper.insertFile(fileVO);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}else {

		}

		
		
		
	}


	
	
	
}
