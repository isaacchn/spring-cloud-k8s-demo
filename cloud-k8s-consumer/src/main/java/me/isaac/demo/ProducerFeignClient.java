package me.isaac.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cloud-k8s-producer")
public interface ProducerFeignClient {
    @PostMapping(value = "/producer/send")
    ProducerResultVO produce(@RequestBody ProducerDTO dto);
}
