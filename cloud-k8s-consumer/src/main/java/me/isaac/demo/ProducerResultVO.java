package me.isaac.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProducerResultVO {
    private String phone;
    private String smsSendResult;
    private String mailto;
    private String mailSendResult;
}
