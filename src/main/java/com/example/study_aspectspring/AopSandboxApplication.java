package com.example.study_aspectspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

public class AopSandboxApplication {
    private static  final Logger LOGGER = LoggerFactory.getLogger(AopSandboxApplication.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigReactiveWebApplicationContext("com.example.study_aspectspring");
        var greetingService = ctx.getBean(GreetingService.class);


        LOGGER.info(greetingService.getGreeting("Alexander"));
        LOGGER.info(greetingService.getGreeting("Alexander","Muller"));
        LOGGER.info(greetingService.getGreetingAnnotated("Anny"));
    }
}
