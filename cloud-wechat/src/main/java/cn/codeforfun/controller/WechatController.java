package cn.codeforfun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangbin
 */
@RestController
@Api(description = "微信模块")
public class WechatController {
  @GetMapping("/")
  @ApiOperation("测试接口")
  public String test() {
    return "wechat test";
  }
}
