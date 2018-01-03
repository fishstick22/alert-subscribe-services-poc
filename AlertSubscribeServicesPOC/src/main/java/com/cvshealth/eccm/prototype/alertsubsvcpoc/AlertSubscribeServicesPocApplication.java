package com.cvshealth.eccm.prototype.alertsubsvcpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = "com.cvshealth.eccm.prototype.alertsubsvcpoc")
@EnableAutoConfiguration
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:auth0.properties")
})
public class AlertSubscribeServicesPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertSubscribeServicesPocApplication.class, args);
	}
	
    //Enable Global CORS support for the application
	// Don't need all this if you just call the right damn URI's
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        //.allowedOrigins("http://localhost:4200")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
//                        .allowedHeaders("header1", "header2") //What is this for?
//                        .allowCredentials(true);
//            }
//        };
//    }
}
