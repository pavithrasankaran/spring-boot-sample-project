package com.example.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Autowired
	private Environment environment;

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Ovitag Api List", "Your REST API for web app", "1.0", "Terms of service",
				new Contact("Pradeep", "http://techie-mixture.blogspot.com/", ""), "", "");
		return apiInfo;
	}

	@Bean
	public SecurityConfiguration securityInfo() {
		return new SecurityConfiguration(null, null, null, null, "", ApiKeyVehicle.HEADER, "Authorization", "");
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("1.JWT_GROUP")//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("com.example.controller")).build().apiInfo(apiInfo())
				.securitySchemes(Lists.newArrayList(apiKey())).apiInfo(metadata())//
				.useDefaultResponseMessages(false)//
				// .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token",
				// "Authorization", "Header"))))//
				// .tags(new Tag("users", "Operations about users"))//
				// .tags(new Tag("ping", "Just a ping"))//
				.genericModelSubstitutes(Optional.class);
	}

	private ApiInfo metadata() {
		String[] profiles = this.environment.getActiveProfiles();
		String currentProfileName = "";
		if (profiles != null && profiles.length > 0) {
			currentProfileName = profiles[0];
		}

		return new ApiInfoBuilder()//
				.title("OVITAG API DOCUMENTATION LIST.. 18-DEC-2019 ...(Environment :" + currentProfileName + ")")//
				.description("Api Documentation")//
				.version("1.0.0")//
				.license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
				.contact(new Contact(null, null, "trackerwave@gmail.com"))//
				.build();
	}

	@Bean
	public Docket apiKeyAPI() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("2.API_KEY_GROUP")//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("com.example.controller")).build().apiInfo(apiInfo())
				.securitySchemes(Lists.newArrayList(apiKey())).apiInfo(metadata())//
				.useDefaultResponseMessages(false)//
				.securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("API_KEY", "API_KEY", "Header"))))
				.genericModelSubstitutes(Optional.class);
	}
}