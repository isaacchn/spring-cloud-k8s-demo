package me.isaac.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cloud-k8s-producer")
public interface TestFeignClient {
    @GetMapping(value = "/producer/{code}")
    public String test2(@PathVariable("code") String code);
}
