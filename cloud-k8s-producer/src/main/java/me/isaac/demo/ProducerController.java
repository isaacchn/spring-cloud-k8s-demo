package me.isaac.demo;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import me.isaac.demo.mail.MailFeignClient;
import me.isaac.demo.mail.MailResultVO;
import me.isaac.demo.mail.MailSendDTO;
import me.isaac.demo.sms.SmsFeignClient;
import me.isaac.demo.sms.SmsResultVO;
import me.isaac.demo.sms.SmsSendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProducerController {
    @Autowired
    private SmsFeignClient smsFeignClient;

    @Autowired
    private MailFeignClient mailFeignClient;

    @PostMapping("/producer/send")
    public InfoResultVO producer(@RequestBody InfoSendDTO dto) {
        log.info(String.format("接收到请求 --> %s", JSONUtil.toJsonStr(dto)));
        SmsSendDTO smsDTO = new SmsSendDTO(dto.getPhone(), dto.getInfo());
        MailSendDTO mailDTO = new MailSendDTO(dto.getMailto(), dto.getInfo());

        SmsResultVO smsVO = smsFeignClient.sendSms(smsDTO);
        log.info(String.format("接收到Feign返回结果 --> %s", JSONUtil.toJsonStr(smsVO)));
        MailResultVO mailVO = mailFeignClient.sendMail(mailDTO);
        log.info(String.format("接收到Feign返回结果 --> %s", JSONUtil.toJsonStr(mailVO)));

        InfoResultVO infoVO = new InfoResultVO(smsVO.getPhone(), smsVO.getSendInfo(),
                mailVO.getMailto(), mailVO.getSendInfo());

        return infoVO;
    }
}
