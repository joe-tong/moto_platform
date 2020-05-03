package com.tulin.platform_system.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @Description swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket TestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("模板API文档")
                .apiInfo(apiInfo("参数说明"))
                .produces(Sets.newHashSet("application/json;charset=UTF-8"))
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tulin.platform_system.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameter());
    }

    private ApiInfo apiInfo(String descTitle) {
        return new ApiInfoBuilder()
                .title("模板接口文档")
                .description(SwaggerInfo.init(descTitle))
                .version("1.0.0")
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("TPP", "", ""))
                .build();
    }

    /**
     * 添加head参数
     *
     * @return List<Parameter>
     */
    private List<Parameter> parameter() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = Lists.newArrayList();
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
}
