package cn.codeforfun.controller;

import cn.codeforfun.dao.UserDao;
import cn.codeforfun.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Resource
  private UserDao userDao;

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public User get(@PathVariable Integer id) {
    return userDao.findOne(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<User> list() {
    return userDao.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public boolean save(@RequestBody User user) {
    userDao.save(user);
    return true;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public boolean delete(@PathVariable Integer id) {
    userDao.delete(id);
    return true;
  }

}
