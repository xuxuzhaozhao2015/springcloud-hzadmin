package top.xuxuzhaozhao.servicefeign.service.impl;

import org.springframework.stereotype.Component;
import top.xuxuzhaozhao.servicefeign.service.HiHystrixService;

@Component
public class HiHystrixServiceImpl implements HiHystrixService {
    @Override
    public String sayHiFromServiceHi(String name) {
        return "hello" + name +", this message send failed";
    }
}
