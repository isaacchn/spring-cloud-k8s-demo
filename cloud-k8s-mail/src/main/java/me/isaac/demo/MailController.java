package me.isaac.demo;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MailController {
    @PostMapping("/mail/send")
    public MailResultVO send(@RequestBody MailSendDTO dto) {
        String mailto = dto.getMailto();
        String content = dto.getContent();
        MailResultVO vo = null;
        if (RandomUtils.nextBoolean()) {
            vo = new MailResultVO(mailto, content, true, "邮件发送成功！");
        } else {
            vo = new MailResultVO(mailto, content, false, "邮件发送失败！");
        }
        log.info(String.format("MailController返回结果 --> %s", JSONUtil.toJsonStr(vo)));
        return vo;
    }
}