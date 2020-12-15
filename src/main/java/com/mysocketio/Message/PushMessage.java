package com.mysocketio.Message;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @Author: panyusheng
 * @Date: 2020/12/14
 * @Version 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PushMessage {
    @ApiModelProperty(value = "登录用户编号")
    private String loginUserName;

    @ApiModelProperty(value = "推送内容")
    private String content;

}
