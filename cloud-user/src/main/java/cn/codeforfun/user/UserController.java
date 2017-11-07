package cn.codeforfun.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author wangbin
 */
@RestController
@Api(description = "用户模块")
public class UserController {


  @Resource
  private UserDao userDao;
  @Resource
  private UserService userService;

  @ApiOperation("根据Id查询用户")
  @GetMapping("{id}")
  public User get(@PathVariable Integer id) {
    return userDao.findOne(id);
  }

  @ApiOperation("查询所有用户")
  @GetMapping("/")
  public List<User> list() {
    return userService.findAll();
  }

  @ApiOperation("分页查询用户")
  @GetMapping("{page}/{size}")
  public Page<User> list(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    return userService.findPage(page, size);
  }

  @ApiOperation("保存用户")
  @PostMapping("/save")
  public boolean save(@RequestBody User user) {
    userDao.save(user);
    return true;
  }

  @ApiOperation("根据Id删除用户")
  @DeleteMapping("{id}")
  public boolean delete(@PathVariable Integer id) {
    userDao.delete(id);
    return true;
  }

}
