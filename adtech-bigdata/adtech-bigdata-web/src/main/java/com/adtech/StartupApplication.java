package com.adtech;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


//@MapperScan("com.c3.bidhelper.dao")
//@EnableMongoRepositories(basePackages = {"com.yade"})
@ComponentScan(basePackages={"com.adtech"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

//@EnableScheduling //定时任务
public class StartupApplication {

    public static void main(String[] args) {

      SpringApplication.run(StartupApplication.class, args);

    }


}
