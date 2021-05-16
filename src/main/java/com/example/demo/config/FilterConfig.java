package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.filter.LoginCheckFilter;

@Configuration
public class FilterConfig implements WebMvcConfigurer {
	@Bean
	public FilterRegistrationBean<LoginCheckFilter> configLoginCheck(){
		FilterRegistrationBean<LoginCheckFilter> bean = 
				new FilterRegistrationBean<LoginCheckFilter>(); 
		bean.setFilter(new LoginCheckFilter());
		bean.setOrder(1);
		return bean;
	}
}
