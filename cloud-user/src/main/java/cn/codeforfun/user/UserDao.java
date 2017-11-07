package cn.codeforfun.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author wangbin
 */
public interface UserDao extends JpaRepository<User, Integer> {

  @Query("select u from User u")
  User findByParam();
}
