package com.yesido.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class StartRunner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.profiles.active}")
    private String profile;
    @Value("${server.port}")
    private String webport;

    @Override
    public void run(String... args) throws Exception {
        logger.info("启动完成，profile：{}，webport：{}", profile, webport);
    }
}
