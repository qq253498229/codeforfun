package cn.codeforfun.user;

import cn.codeforfun.role.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbin
 */
@Entity
@Table(name = "users")
@Data
public class User {
  @Id
  private String username;
  private String password;
  private String enabled = "Y";

  @ManyToMany
  @JoinTable(
          name = "authorities",
          joinColumns = @JoinColumn(name = "username"),
          inverseJoinColumns = @JoinColumn(name = "authority")
  )
  private List<Role> roles = new ArrayList<>();

}
