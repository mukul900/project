package com.stackroute.demo;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.stackroute.demo.appConfig.JWTFilter;

@SpringBootApplication
public class FavouriteFoodServiceApplication {

	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(FavouriteFoodServiceApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<?> filterRegistrationBean(){
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
		filter.addUrlPatterns("/api/v1/*");
		filter.setFilter(new JWTFilter());
		return filter;
		
		
	}


}
