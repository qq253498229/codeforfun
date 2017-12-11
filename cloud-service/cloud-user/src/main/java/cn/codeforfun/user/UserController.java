package cn.codeforfun.user;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author wangbin
 */
@RestController
public class UserController implements UserClient {


  @Resource
  private UserDao userDao;
  @Resource
  private UserService userService;

  @Override
  public UserDTO get(Long id) {
    return userDao.findOne(id);
  }

  @Override
  public List list() {
    return userDao.findAll();
  }

  @Override
  public Page list(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    return userService.findPage(page, size);
  }

  @Override
  public boolean save(UserDTO user) {
    userService.save(user);
    return true;
  }

  @Override
  public boolean delete(Long id) {
    userDao.delete(id);
    return true;
  }
}
