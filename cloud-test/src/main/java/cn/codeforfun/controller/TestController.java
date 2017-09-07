package cn.codeforfun.controller;

import cn.codeforfun.client.UserClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
  @Resource
  private UserClient userClient;

  @RequestMapping("/test")
  public String test() {
    return userClient.test();
  }
}
