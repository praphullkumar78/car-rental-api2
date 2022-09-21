package com.ty.carrentalapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class MyConfig {

	@Bean
	public Docket getDocket() {

		Contact contact = new Contact("Testyantra Global Team", "https://testyantraglobal.com/",
				"test@testyantraglobal.com");

		@SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("Car-Rental Service Book our Car_Rental Service To Reach your Destiny",
				"This has list all the end points for testyantraglobal shopping kart application", "1.0",
				"https://testyantraglobal.com/services/software-development/", contact, "Apache 2.0",
				"https://testyantraglobal.com/services/software-development/", vendorExtensions);
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.carrentalapp")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}
