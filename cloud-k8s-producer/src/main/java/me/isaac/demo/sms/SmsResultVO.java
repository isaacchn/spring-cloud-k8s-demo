package me.isaac.demo.sms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SmsResultVO {
    private String phone;
    private String text;
    private boolean isSuccessful;
    private String sendInfo;
}
