package cn.codeforfun.controller;

import cn.codeforfun.feign.UserClient;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TestController {
  private static final Logger log = Logger.getLogger(TestController.class);
  @Resource
  private UserClient userClient;

  @GetMapping("/test")
  public String test() {
    return userClient.test();
  }

  @GetMapping("/user/{page}/{size}")
  public Map list(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    return userClient.list(page, size);
  }
}
