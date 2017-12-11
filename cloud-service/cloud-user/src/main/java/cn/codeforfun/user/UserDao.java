package cn.codeforfun.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangbin
 */
public interface UserDao extends JpaRepository<User, Long> {

}
