package cn.codeforfun.feign;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wangbin
 */
@Component
public class UserFallback implements UserClient{
  @Override
  public List<Map> list() {
    System.out.println("list");
    return null;
  }

  @Override
  public Map get(Integer id) {
    System.out.println("get");
    return null;
  }
}
