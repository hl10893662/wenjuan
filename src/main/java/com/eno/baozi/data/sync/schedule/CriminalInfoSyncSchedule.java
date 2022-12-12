package com.eno.baozi.data.sync.schedule;

import com.eno.baozi.data.sync.task.CriminalInfoSyncService;
import com.eno.baozi.data.sync.task.CriminalInfoSyncService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class CriminalInfoSyncSchedule {
    private final Logger logger = LoggerFactory.getLogger(CriminalInfoSyncSchedule.class);

    @Value("${sync.enable}")
    boolean isSyncEnable;

    @Autowired
    private CriminalInfoSyncService1 criminalInfoSyncService;
    //3.添加定时任务
    @Scheduled(cron = "${sync.rate}")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        try{
            if (!isSyncEnable){
                logger.info("同步未开启");
                return ;
            }
            logger.info("开始同步criminal信息: " + LocalDateTime.now());
            criminalInfoSyncService.sync();
        }catch(Exception e){
            logger.error("同步criminal信息失败",e);
        }
        logger.info("结束同步criminal信息: " + LocalDateTime.now());

    }

}
