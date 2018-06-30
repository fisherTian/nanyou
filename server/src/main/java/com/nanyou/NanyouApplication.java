package com.nanyou;

import com.nanyou.common.SpringUtil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAuthorizationServer
@EnableScheduling
@MapperScan(basePackages = "com.nanyou.mybatis.dao")
public class NanyouApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NanyouApplication.class);
        //pid
        springApplication.addListeners(new ApplicationPidFileWriter());
        ApplicationContext app = springApplication.run(args);
        //profiles
        String[] activeProfiles = app.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            System.out.println("Spring Boot 使用profile为:" + profile);
        }
        SpringUtil.setApplicationContext(app);
    }
}
