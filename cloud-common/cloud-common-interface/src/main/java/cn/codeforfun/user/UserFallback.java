package cn.codeforfun.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Package cn.codeforfun.user
 * Project codeforfun
 * Email 253498229@qq.com
 *
 * @author WangBin
 * @version 1.0.0
 * @date Created on 2017/11/28 下午2:35
 */
@Component
@Slf4j
public class UserFallback implements UserClient {
  @Override
  public UserDTO get(Long id) {
    log.error("Error UserFallback.get(id):id={}", id);
    return null;
  }

  @Override
  public List<UserDTO> list() {
    log.error("Error UserFallback.list()");
    return null;
  }

  @Override
  public Page<UserDTO> list(Integer page, Integer size) {
    log.error("Error UserFallback.list(page,size):page={},size={}", page, size);
    return null;
  }

  @Override
  public boolean save(UserDTO user) {
    try {
      log.error("Error UserFallback.save(user):user={}", new ObjectMapper().writeValueAsString(user));
    } catch (JsonProcessingException e) {
      log.error(e.getMessage());
    }
    return false;
  }

  @Override
  public boolean delete(Long id) {
    log.error("Error UserFallback.delete(id):id={}", id);
    return false;
  }
}
