package com.cos.pic;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cos.pic.utils.MyPath;

@Controller
public class TestController {

	@GetMapping("/send")
	public String send() {
		return "send";
	}
	
	@GetMapping("/feed")
	public String feed() {
		return "feed";
	} 
	
	@PostMapping("/image")
	public @ResponseBody String image(MultipartFile pic) {
		
		// 중복되지 않는 난수를 발생시킴
		UUID uuid = UUID.randomUUID();
		
		String imageFileName = uuid + "_" + pic.getOriginalFilename(); // 이러면 파일명이 겹칠 일이 없다.
		 
		Path imagePath = Paths.get(MyPath.IMAGEPATH+imageFileName);
		try {
			Files.write(imagePath, pic.getBytes());
			// DB에 파일경로를 저장! imageFileName 저장하기
			// DB에는 파일의 경로가 아닌 네임만 저장해야 함. 
			// 왜? 서버를 이전하는 순간 망함 경로를 다 수정해야 하는 일이 생김
			// DB에 파일 풀경로를 저장하면? 망함
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageFileName;
	}
}
