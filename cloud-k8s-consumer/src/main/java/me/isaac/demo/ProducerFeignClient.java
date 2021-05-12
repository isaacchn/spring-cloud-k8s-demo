package me.isaac.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cloud-k8s-producer",contextId = "cloud-k8s-consumer-feign")
public interface ProducerFeignClient {
    @PostMapping(value = "/producer/send")
    ProducerResultVO produce(@RequestBody ProducerDTO dto);
}
