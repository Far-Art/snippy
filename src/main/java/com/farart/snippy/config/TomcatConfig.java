package com.farart.snippy.config;

import org.apache.catalina.valves.AccessLogValve;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

//    @Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
//        return container -> {
//            AccessLogValve accessLogValve = new AccessLogValve();
//            accessLogValve.setDirectory("D:/Tomcat Logs");
//            container.addEngineValves(accessLogValve);
//        };
//    }
}
