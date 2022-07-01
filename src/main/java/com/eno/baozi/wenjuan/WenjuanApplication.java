package com.eno.baozi.wenjuan;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

//@MapperScan("com.eno")
//@SpringBootApplication
//public class WenjuanApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(WenjuanApplication.class, args);
//    }
//
//    @Bean
//    public TomcatServletWebServerFactory servletContainer() { //springboot2 新变化
//
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//
//            @Override
//            protected void postProcessContext(Context context) {
//
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
//        return tomcat;
//    }
//
//    private Connector initiateHttpConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(8080);
//        connector.setSecure(false);
//        connector.setRedirectPort(9080);
//        return connector;
//    }
//}

@MapperScan("com.eno")
@SpringBootApplication
public class WenjuanApplication {
    public static void main(String[] args) {
        SpringApplication.run(WenjuanApplication.class, args);
    }

}
