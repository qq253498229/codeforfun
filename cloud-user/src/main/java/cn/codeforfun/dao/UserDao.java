package cn.codeforfun.dao;

import cn.codeforfun.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Integer> {

  @Query("select u from User u")
  User findByParam();
}
