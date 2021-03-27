package me.isaac.demo.sms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cloud-k8s-sms")
public interface SmsFeignClient {
    @PostMapping(value = "/sms/send")
    SmsResultVO sendSms(@RequestBody SmsSendDTO dto);
}
