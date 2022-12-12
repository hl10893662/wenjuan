package com.eno.baozi.data.sync.schedule;

import com.eno.baozi.wenjuan.service.impl.OutlineQuestionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class TestSchedule {
    private final Logger logger = LoggerFactory.getLogger(TestSchedule.class);

    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        logger.info("执行静态定时任务时间: " + LocalDateTime.now());

    }

}
