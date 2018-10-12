package com.example.base.config;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // swagger(v2)を有効にする
public class Swagger2Config {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
    	//Adding Header
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("headerName").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        List<Parameter> aParameters = new ArrayList<Parameter>();
        aParameters.add(aParameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                		.globalOperationParameters(aParameters)
                        .select()
                        .apis(RequestHandlerSelectors.any())              
                        .paths(PathSelectors.any())                          
                        .build()              
//                        .paths(paths())
//                        .build()
                        .apiInfo(apiInfo());
    }

//    private Predicate<String> paths() {
//
//        // 仕様書生成対象のURLパスを指定する
//        return Predicates.and(
//                Predicates.not(Predicates.containsPattern("/hogehoge-view")),
//                Predicates.or(
//                Predicates.containsPattern("/data/*"),
//                Predicates.containsPattern("/*"),
//                Predicates.containsPattern("/authority/*"),
//                Predicates.containsPattern("/file/*")));
//    }
//
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "HogeHoge System Web API",              // title
                "HogeHoge System の Web API 仕様書",    // description
                "0.0.1",                                // version
                "",                                     // terms of service url
                "HogeHoge",                             // created by
                "HogeHoge Co. Ltd",                     // license
                "");                                    // license url
        return apiInfo;
    }
}