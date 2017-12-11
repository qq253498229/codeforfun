package cn.codeforfun.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Package cn.codeforfun.user
 * Project codeforfun
 * Email 253498229@qq.com
 *
 * @author WangBin
 * @version 1.0.0
 * @date Created on 2017/11/28 下午2:17
 */
@FeignClient(name = "cloud-user", fallback = UserFallback.class)
public interface UserClient {
  /**
   * 通过主键获取用户实体
   *
   * @param id 主键
   * @return 用户实体
   */
  @GetMapping("/{id}")
  UserDTO get(@PathVariable Long id);

  /**
   * 获取用户列表
   *
   * @return 用户列表
   */
  @GetMapping("/")
  List<UserDTO> list();

  /**
   * 获取用户分页数据
   *
   * @param page 页码
   * @param size 条数
   * @return 分页数据
   */
  @GetMapping("/{page}/{size}")
  Page<UserDTO> list(@PathVariable("page") Integer page, @PathVariable("size") Integer size);

  /**
   * 保存用户数据
   *
   * @param user 用户实体
   * @return 是否成功
   */
  @PostMapping("/")
  boolean save(@RequestBody UserDTO user);

  /**
   * 根据主键删除用户
   *
   * @param id 主键
   * @return 是否成功
   */
  @DeleteMapping("/{id}")
  boolean delete(@PathVariable Long id);
}
