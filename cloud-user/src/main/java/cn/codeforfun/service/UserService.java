package cn.codeforfun.service;

import cn.codeforfun.dao.UserDao;
import cn.codeforfun.entity.User;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class UserService {
  private static final Logger log = Logger.getLogger(UserService.class);
  @Resource
  private UserDao userDao;

  public Page<User> findPage(int page, int size) {
    log.info("page===\r\n" + page);
    log.info("size===\r\n" + size);
    return userDao.findAll(new PageRequest(page - 1, size));
  }
}
