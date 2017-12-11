package cn.codeforfun.role;

import cn.codeforfun.BaseEntity;
import cn.codeforfun.user.UserDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Package cn.codeforfun.role
 * Project codeforfun
 * Email 253498229@qq.com
 *
 * @author WangBin
 * @version 1.0.0
 * @date Created on 2017/11/28 下午2:25
 */
@Data
public class RoleDTO<T extends UserDTO> extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 7395289559933676576L;
  private String code;
  private String description;

  private List<T> users;
}
