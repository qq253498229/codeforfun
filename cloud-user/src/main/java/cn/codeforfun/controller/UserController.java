package cn.codeforfun.controller;

import cn.codeforfun.dao.UserDao;
import cn.codeforfun.entity.User;
import cn.codeforfun.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {


  @Resource
  private UserDao userDao;
  @Resource
  private UserService userService;

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public User get(@PathVariable Integer id) {
    return userDao.findOne(id);
  }

  @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
  public Page<User> list(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    return userService.findPage(page, size);
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
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
