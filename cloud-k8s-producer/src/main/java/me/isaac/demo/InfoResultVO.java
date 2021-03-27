package me.isaac.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoResultVO {
    private String phone;
    private String smsSendResult;
    private String mailto;
    private String mailSendResult;
}
