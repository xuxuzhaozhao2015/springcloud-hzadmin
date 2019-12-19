package top.xuxuzhaozhao.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.xuxuzhaozhao.servicefeign.service.HiHystrixService;

@RestController
public class HiController {

    @Autowired
    private HiHystrixService hiHystrixService;

    @GetMapping("/hello/{name}")
    public String sayHi(@PathVariable String name){
        return hiHystrixService.sayHiFromServiceHi(name);
    }
}
