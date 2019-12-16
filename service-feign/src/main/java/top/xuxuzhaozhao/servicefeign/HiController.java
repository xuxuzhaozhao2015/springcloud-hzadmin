package top.xuxuzhaozhao.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.xuxuzhaozhao.servicefeign.remote.ServiceHi;

@RestController
public class HiController {

    @Autowired
    private ServiceHi serviceHi;

    @GetMapping("/hello/{name}")
    public String sayHi(@PathVariable String name){
        return serviceHi.sayHiFromServiceHi(name);
    }
}
