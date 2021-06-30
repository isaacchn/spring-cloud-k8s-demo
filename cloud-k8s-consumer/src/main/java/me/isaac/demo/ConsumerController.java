package me.isaac.demo;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private ProducerFeignClient producerFeignClient;

    @PostMapping("/consumer/send")
    public ProducerResultVO consumer(@RequestBody ConsumerDTO dto) {
        String uuid = UUID.randomUUID().toString();
        log.info(String.format("接收到请求 --> %s", JSONUtil.toJsonStr(dto)));
        log.info(String.format("生产消息体 --> %s", uuid));
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.setPhone(dto.getPhone());
        producerDTO.setMailto(dto.getMailto());
        producerDTO.setInfo(uuid);

        ProducerResultVO vo = producerFeignClient.produce(producerDTO);
        return vo;
    }
}
