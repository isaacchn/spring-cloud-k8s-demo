package me.isaac.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoSendDTO {
    private String phone;
    private String mailto;
    private String info;
}
