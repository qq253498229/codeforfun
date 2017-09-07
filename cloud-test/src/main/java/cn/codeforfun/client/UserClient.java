package cn.codeforfun.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient("cloud-user")
public interface UserClient {
  @GetMapping("/user/{page}/{size}")
  Map list(@PathVariable("page") Integer page, @PathVariable("size") Integer size);

  @GetMapping("/test")
  String test();
}
