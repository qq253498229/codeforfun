package cn.codeforfun;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author wangbin
 */
@SpringCloudApplication
@EnableFeignClients
@EnableSwagger2
public class WechatApp {
  public static void main(String[] args) {
    new SpringApplicationBuilder(WechatApp.class).web(true).run(args);
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("cn.codeforfun"))
            .paths(PathSelectors.any())
            .build().apiInfo(new ApiInfo(
                    "微信模块",
                    "微信模块API",
                    "1.0",
                    null,
                    new Contact("王斌", "https://codeforfun.cn", "253498229@qq.com"),
                    null,
                    null,
                    new ArrayList<>()));
  }
}
