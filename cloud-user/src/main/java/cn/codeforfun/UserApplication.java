package cn.codeforfun;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class UserApplication {
  @RequestMapping("/")
  public String index() {
    return "user index";
  }

  public static void main(String[] args) {
    new SpringApplicationBuilder(UserApplication.class).web(true).run(args);
  }
}
