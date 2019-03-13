package com.training.memberweb;

import com.training.memberweb.Entity.ApiKeyHandlerMethodArgument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class MemberWebApplication implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new ApiKeyHandlerMethodArgument());
	}

	public static void main(String[] args) {
		SpringApplication.run(MemberWebApplication.class, args);
	}

}
