package top.wjup.demo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Create by wjup on 2020/5/16 15:36
 */
@Component
public class ApiTestController implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(ApiTestController.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("开机启动...");
    }

}
