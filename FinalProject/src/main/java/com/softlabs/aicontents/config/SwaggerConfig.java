package com.softlabs.aicontents.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new Info()
                                .title("Softlabs 7팀 백엔드 API")
                                .description("Softlabs 프로젝트 백엔드 API 명세서")
                                .version("v1.0"));
        }
//        @Bean
//        public GroupOpenApi publicApi(){
//                return GroupOpenApi.builder()
//                        .group("shcheduler-api")
//                        .pathsToMatch("/api/**")
//                        .build();
//        }
//
//        @Bean
//        public OpenAPI SpringShopOpenAPI(){
//                return new OpenAPI()
//                        .info(new Info().title("AI 스케줄러 API")
//                        .description("스케줄링 파이프라인 API")
//                        .version("v1.0.0")
//                );
//        }






}
