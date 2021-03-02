package me.isaac.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @GetMapping("/producer/{code}")
    public Producer producer(@PathVariable String code) {
        return new Producer(code);
    }
}
