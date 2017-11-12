package cn.codeforfun;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author wangbin
 */
@Component
@Data
@ConfigurationProperties("zuul")
public class ZuulConst {
  private Map<String, ZuulRoute> routes = new LinkedHashMap<>();
  private String prefix;

  @Data
  public static class ZuulRoute {
    private String name;
    private String version;
    private String path;
    private String serviceId;
  }
}
