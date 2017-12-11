package cn.codeforfun.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author wangbin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
  @Resource
  private UserDao userDao;

  public Page findPage(int page, int size) {
    return userDao.findAll(new PageRequest(page - 1, size));
  }

  public void save(UserDTO user) {
    User one;
    if (user.getId() != null) {
      one = (User) user;
    } else {
      one = userDao.findOne(user.getId());
      one.setUsername(user.getUsername());
      one.setEnabled(user.getEnabled());
      one.setRoles(user.getRoles());
    }
    userDao.save(one);
  }
}
