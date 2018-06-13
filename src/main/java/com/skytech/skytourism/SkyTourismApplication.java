package com.skytech.skytourism;

import com.skytech.application.jwt.Audience;
import com.skytech.application.jwt.filter.HTTPBearerAuthorizeAttribute;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

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

    /**
     * 加载自定义yml配置文件
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("jwt.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}
