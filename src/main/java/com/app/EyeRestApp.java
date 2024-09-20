package com.app;

import com.app.service.TaskScheduler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor

public class EyeRestApp implements CommandLineRunner {

    private final TaskScheduler taskScheduler;

    public static void main(String[] args) {
        SpringApplication.run(EyeRestApp.class,args);
    }
    @Override
    public void run(String... args) throws Exception {
        log.info("application started");
        taskScheduler.scheduleTask();
    }
}
