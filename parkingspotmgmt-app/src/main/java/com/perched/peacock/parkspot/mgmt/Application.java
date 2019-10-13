package com.perched.peacock.parkspot.mgmt;

import io.swagger.models.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("PerchedPeacock Parking Management")
                .description("A Rest API to manage the parking <ul><li>Parking Lot establishment and management</li><li>Parking sopt availability and booking</li><li>Parking spot booking history and record keeping</li>")
                .contact("venkata.vallabhaneni@gmail.com")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.perched.peacock.parkspot.mgmt.controller"))

                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo());
    }

}
