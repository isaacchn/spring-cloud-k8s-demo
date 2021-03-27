package me.isaac.demo;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private ProducerFeignClient producerFeignClient;

    @PostMapping("/consumer/send")
    public ProducerResultVO consumer(@RequestBody ConsumerDTO dto) {
        String uuid = UUID.randomUUID().toString();
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.setPhone(dto.getPhone());
        producerDTO.setMailto(dto.getMailto());
        producerDTO.setInfo(uuid);

        ProducerResultVO vo = producerFeignClient.produce(producerDTO);
        return vo;
    }
}
