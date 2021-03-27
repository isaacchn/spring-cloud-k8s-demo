package me.isaac.demo.mail;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cloud-k8s-mail")
public interface MailFeignClient {
    @PostMapping(value = "/mail/send")
    MailResultVO sendMail(@RequestBody MailSendDTO dto);
}
