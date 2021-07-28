package com.cos.pic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.cos.pic.utils.MyPath;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	// 외부에 있는 폴더를 내 프로젝트에서 찾을 수 있게 세팅하는 작업
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("나 실행됐어?");
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/upload/**")
				.addResourceLocations("file:///"+MyPath.IMAGEPATH)
				.setCachePeriod(60*10*6) // 1 시간
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
				
		
	}

}
