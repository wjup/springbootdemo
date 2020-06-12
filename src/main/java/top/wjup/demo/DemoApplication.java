package top.wjup.demo;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SQL注入拦截器的注解
 *
 * 排除掉工作流的class，否则报错
 */
@ServletComponentScan
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
