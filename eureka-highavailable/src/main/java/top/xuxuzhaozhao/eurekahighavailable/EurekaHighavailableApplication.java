package top.xuxuzhaozhao.eurekahighavailable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHighavailableApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHighavailableApplication.class, args);
    }

}
