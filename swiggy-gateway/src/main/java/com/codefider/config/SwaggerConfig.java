/*
 * package com.codefider.config;
 * 
 * import java.util.Collections;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import springfox.documentation.builders.ParameterBuilder; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket;
 * 
 * @Configuration public class SwaggerConfig {
 * 
 * @Bean public Docket api() { return new
 * Docket(DocumentationType.SWAGGER_2).select()
 * .apis(RequestHandlerSelectors.basePackage("com.codefider")).paths(
 * PathSelectors.any()).build() .globalOperationParameters(
 * Collections.singletonList(new
 * ParameterBuilder().name("X-CSRF-Token").description("CSRF Token")
 * .modelRef(new
 * ModelRef("string")).parameterType("header").required(true).build())); } }
 */