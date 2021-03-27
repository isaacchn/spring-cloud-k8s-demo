package me.isaac.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailResultVO {
    private String mailto;
    private String content;
    private boolean isSuccessful;
    private String sendInfo;
}
