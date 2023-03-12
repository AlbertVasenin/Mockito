package pro.sky.mockito.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.mockito.model.User;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {
  private static User user;
  private static final UserDaoImpl out = mock(UserDaoImpl.class);

  private final String ALBERT = "Albert";
  private final String ELENA = "Elena";
  private final String OLGA = "Olga";
  private final List<User> users = List.of(new User(ALBERT), new User(ELENA),
      new User(OLGA));

  @BeforeEach
  void createNewUser() {
    user = new User(ALBERT);
  }

  @Test
  void shouldFindUserByNameIfExist() {
    when(out.getUserByName(ALBERT)).thenReturn(user);
    assertEquals(user, out.getUserByName(ALBERT));
  }

  @Test
  void shouldReturnNullIfUserNotExist() {
    String SERGEY = "Sergey";
    when(out.getUserByName(SERGEY)).thenReturn(null);
    assertNull(out.getUserByName(SERGEY));
  }

  @Test
  void findAllUsers() {
    when(out.findAllUsers()).thenReturn(users);
    assertEquals(out.findAllUsers(), users);
  }
}