package me.isaac.demo;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SmsController {
    @PostMapping("/sms/send")
    public SmsResultVO send(@RequestBody SmsSendDTO dto) {
        String phone = dto.getPhone();
        String text = dto.getText();
        SmsResultVO vo = null;
        if (RandomUtils.nextBoolean()) {
            vo = new SmsResultVO(phone, text, true, "短信发送成功！");
        } else {
            vo = new SmsResultVO(phone, text, false, "短信发送失败！");
        }
        log.info(String.format("SmsController返回结果 --> %s", JSONUtil.toJsonStr(vo)));
        return vo;
    }
}
