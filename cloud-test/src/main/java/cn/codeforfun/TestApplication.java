package cn.codeforfun;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TestApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(TestApplication.class).web(true).run(args);
  }
}
