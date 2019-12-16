package top.xuxuzhaozhao.eurekahighavailablehi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaHighavailableHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHighavailableHiApplication.class, args);
    }
}
