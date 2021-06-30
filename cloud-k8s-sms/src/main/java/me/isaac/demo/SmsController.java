package me.isaac.demo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

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

    @GetMapping("/sms/ca")
    public String ca() {
        File file = FileUtil.file("dev/ca1.txt");
        List<String> lines = FileUtil.readLines(file, "utf-8");
        return lines.get(0);
    }
}
