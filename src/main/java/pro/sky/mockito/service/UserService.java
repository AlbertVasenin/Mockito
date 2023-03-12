package pro.sky.mockito.service;

import pro.sky.mockito.dao.UserDaoImpl;
import pro.sky.mockito.model.User;

public class UserService {

  private final UserDaoImpl userDao;

  public UserService(UserDaoImpl userDao) {
    this.userDao = userDao;
  }

  public boolean checkUserExist(User user) {
    User userByName = userDao.getUserByName(user.getName());
    return userByName != null;
  }
}
