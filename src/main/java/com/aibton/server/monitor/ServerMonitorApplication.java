package com.aibton.server.monitor;

import com.aibton.framework.config.AibtonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author huzhihui
 */
@Import(value = AibtonConfig.class)
@ServletComponentScan
@EnableTransactionManagement
@EnableSwagger2
@SpringBootApplication
public class ServerMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerMonitorApplication.class, args);
    }
}
