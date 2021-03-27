package me.isaac.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsumerController {
    @Autowired
    private ProducerFeignClient producerFeignClient;

    @GetMapping("/consumer/{code}")
    public String consumer(@PathVariable(name = "code") String code) {
        String result = producerFeignClient.produce(code);
        return result;
    }
}
