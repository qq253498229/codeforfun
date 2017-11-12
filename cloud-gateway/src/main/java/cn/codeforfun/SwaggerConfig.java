package cn.codeforfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangbin
 */
@Configuration
@EnableSwagger2
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider {
  @Resource
  private ZuulConst zuulConst;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("cn.codeforfun"))
            .paths(PathSelectors.any())
            .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Codeforfun")
            .contact(new Contact("王斌", "https://codeforfun.cn", "253498229@qq.com"))
            .version("1.0")
            .build();
  }

  @Override
  public List<SwaggerResource> get() {
    List<SwaggerResource> resources = new ArrayList<>();
    for (Map.Entry<String, ZuulConst.ZuulRoute> entry : zuulConst.getRoutes().entrySet()) {
      ZuulConst.ZuulRoute value = entry.getValue();
      if (StringUtils.isEmpty(value.getName())) {
        continue;
      }
      String location = zuulConst.getPrefix() + value.getPath().split("/\\*\\*")[0] + "/v2/api-docs";
      resources.add(swaggerResource(value.getName(), location, value.getVersion()));
    }
    return resources;
  }

  private SwaggerResource swaggerResource(String name, String location, String version) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion(version);
    return swaggerResource;
  }
}
