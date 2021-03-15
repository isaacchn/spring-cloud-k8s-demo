package me.isaac.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsumerController {
    @Autowired
    private ProducerFeignClient producerFeignClient;

    @GetMapping("/consumer")
    public String consumer() {
        String uuid = UUID.randomUUID().toString();
        String result = producerFeignClient.test2(uuid);
        return result;
    }
}
