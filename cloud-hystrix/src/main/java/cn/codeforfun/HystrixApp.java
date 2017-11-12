package cn.codeforfun;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author wangbin
 */
@SpringCloudApplication
@EnableHystrixDashboard
public class HystrixApp {
  public static void main(String[] args) {
    SpringApplication.run(HystrixApp.class);
  }
}
