package me.isaac.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cloud-k8s-producer")
public interface ProducerFeignClient {
    @GetMapping(value = "/producer/{code}")
    String test2(@PathVariable("code") String code);
}
