package cn.codeforfun.role;

import cn.codeforfun.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbin
 */
@Entity
@Table
@Data
@JsonIgnoreProperties("users")
public class Role {
  @Id
  private String code;
  private String description;

  @ManyToMany(mappedBy = "roles")
  private List<User> users = new ArrayList<>();
}
