package com.skytech.skytourism;

import com.skytech.application.jwt.Audience;
import com.skytech.application.jwt.filter.HTTPBearerAuthorizeAttribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.skytech.*"})
@EnableConfigurationProperties(Audience.class)
public class SkyTourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkyTourismApplication.class, args);
    }

    /**
     * jwt 认证过滤
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean jwtFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new HTTPBearerAuthorizeAttribute());
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/users/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
