package top.xuxuzhaozhao.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.xuxuzhaozhao.servicefeign.service.impl.HiHystrixServiceImpl;

@FeignClient(value = "service-hi",fallback = HiHystrixServiceImpl.class)
public interface HiHystrixService {

    @GetMapping("/hi/{name}")
    String sayHiFromServiceHi(@PathVariable(value = "name")String name);
}