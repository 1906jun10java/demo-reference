package com.rev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rev.filter.MyPostFilter;
import com.rev.filter.MyPreFilter;

@Configuration
public class myFilterConfig {

	@Bean
	public MyPreFilter thisIsForThePre() {
		return new MyPreFilter();
	
	}
	
	@Bean
	public MyPostFilter thisIsinThePost() {
		return new MyPostFilter();
	}
	
	
}
