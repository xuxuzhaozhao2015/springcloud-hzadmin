package top.xuxuzhaozhao.eurekahi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class EurekaHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @GetMapping("hi/{name}")
    public String home(@PathVariable String name) {
        return "hi " + name + ",I am from port : " + port;
    }
}
