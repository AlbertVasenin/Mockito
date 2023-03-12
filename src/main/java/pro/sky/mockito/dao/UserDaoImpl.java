package pro.sky.mockito.dao;

import java.util.ArrayList;
import java.util.List;
import pro.sky.mockito.model.User;

public class UserDaoImpl {

  private final List<User> userList = new ArrayList<>();

  public UserDaoImpl() {
    userList.add(new User("Albert"));
    userList.add(new User("Elena"));
    userList.add(new User("Olga"));
    userList.add(new User("Sergey"));
  }

  public User getUserByName(String name) {
    return userList.stream().filter(o -> o.getName().equals(name)).findFirst().orElse(null);
  }

  public List<User> findAllUsers() {
    return userList;
  }
}
