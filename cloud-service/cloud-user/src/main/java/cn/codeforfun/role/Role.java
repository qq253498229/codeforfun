package cn.codeforfun.role;

import cn.codeforfun.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


/**
 * 角色实体类
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
@Table
@Data
@JsonIgnoreProperties("users")
public class Role extends RoleDTO<User> {
  private static final long serialVersionUID = -3406071984754489140L;
  private String code;

  @ManyToMany(mappedBy = "roles")
  private List<User> users = new ArrayList<>();
}
