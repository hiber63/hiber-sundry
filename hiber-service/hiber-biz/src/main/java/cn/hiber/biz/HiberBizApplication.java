package cn.hiber.biz;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author hiber
 */
@SpringBootApplication( exclude = SecurityAutoConfiguration.class)
@EnableJpaAuditing
@ComponentScan("cn.hiber")
public class HiberBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(HiberBizApplication.class,args);
    }
}
