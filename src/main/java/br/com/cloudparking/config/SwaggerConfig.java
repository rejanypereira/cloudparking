package br.com.cloudparking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
@EnableWebMvc
public class SwaggerConfig {
    
    @Bean
    public Docket getDocklet() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.cloudparking"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
            .title("Parking API")
            .description("")
            .version("1.0.0")
            .license("Apache Licence Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0\"")
            .build();
    }

}
