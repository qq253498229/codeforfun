package cn.codeforfun.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangbin
 */
@Entity
@Table
@Data
public class User {
  @Id
  @GeneratedValue
  private Integer id;
  private String username;
  private String password;
}
