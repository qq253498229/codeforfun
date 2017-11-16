package cn.codeforfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author wangbin
 */
@SpringBootApplication
@RestController
public class Oauth2App {

  public static void main(String[] args) {
    SpringApplication.run(Oauth2App.class, args);
  }

  @GetMapping("/user")
  public Principal user(Principal principal) {
    return principal;
  }
}
