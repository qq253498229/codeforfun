package cn.codeforfun.user;

import cn.codeforfun.role.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户实体类
 * Package cn.codeforfun.user
 * Project codeforfun
 * Email 253498229@qq.com
 *
 * @author WangBin
 * @version 1.0.0
 * @date Created on 2017/11/28 下午2:17
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
@Data
public class User extends UserDTO<Role> {
  private static final long serialVersionUID = 6350804382774663749L;
  private String username;
  private String enabled = "Y";
  @ManyToMany
  @JoinTable(
          name = "authorities",
          joinColumns = @JoinColumn(name = "username"),
          inverseJoinColumns = @JoinColumn(name = "authority")
  )
  private List<Role> roles = new ArrayList<>();
}
