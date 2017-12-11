package cn.codeforfun.user;

import cn.codeforfun.BaseEntity;
import cn.codeforfun.role.RoleDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Package cn.codeforfun.user
 * Project codeforfun
 * Email 253498229@qq.com
 *
 * @author WangBin
 * @version 1.0.0
 * @date Created on 2017/11/28 下午2:24
 */
@Data
public class UserDTO<T extends RoleDTO> extends BaseEntity implements Serializable {
  private static final long serialVersionUID = -824343146994322306L;
  private String username;
  private String password;
  private String enabled;

  private List<T> roles;
}
