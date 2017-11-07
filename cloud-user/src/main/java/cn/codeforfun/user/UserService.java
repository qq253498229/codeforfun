package cn.codeforfun.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author wangbin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
  @Resource
  private UserDao userDao;

  public Page<User> findPage(int page, int size) {
    return userDao.findAll(new PageRequest(page - 1, size));
  }

  public List<User> findAll() {
    return userDao.findAll();
  }
}
