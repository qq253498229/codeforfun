package cn.codeforfun.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author wangbin
 */
@FeignClient(name = "cloud-user", fallback = UserFallback.class)
public interface UserClient {
  /**
   * list
   *
   * @return list
   */
  @GetMapping("/")
  List<Map> list();

  /**
   * 666
   *
   * @param id id
   * @return map
   */
  @GetMapping("{id}")
  Map get(@PathVariable("id") Integer id);

}
