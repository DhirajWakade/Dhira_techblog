package com.techblog.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
@Configuration

public class WebMvcConfigure implements WebMvcConfigurer
{
	 @Bean
	    public SpringResourceTemplateResolver templateResolver() {
	        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	        templateResolver.setCacheable(false);
	        templateResolver.setPrefix("classpath:/template/");
	        templateResolver.setSuffix(".html");
	        return templateResolver;
	    }

	    @Bean
	    public SpringTemplateEngine templateEngine() {
	        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
	        springTemplateEngine.addTemplateResolver(templateResolver());
	        return springTemplateEngine;
	    }

	    @Bean
	    public ThymeleafViewResolver viewResolver() {
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        viewResolver.setOrder(1);
	        return viewResolver;
	    }
	    
	    
	    @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/","classpath:/image/")
            .setCachePeriod(0);
        }
	    
	   
}
