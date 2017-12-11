package cn.codeforfun.controller;

import cn.codeforfun.user.UserClient;
import cn.codeforfun.user.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangbin
 */
@RestController
@Api(description = "微信模块")
public class WechatController {
  @Resource
  UserClient userClient;

  @GetMapping("/")
  @ApiOperation("测试接口")
  public List<UserDTO> test() {
    return userClient.list();
  }

  @GetMapping("/test")
  public String test1() {
    return "wechat test";
  }
}
