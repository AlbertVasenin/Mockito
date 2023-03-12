package pro.sky.mockito.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.mockito.dao.UserDaoImpl;
import pro.sky.mockito.model.User;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
  private final UserDaoImpl userDaoMock = mock(UserDaoImpl.class);
  private UserService out;
  private static User ALBERT;
  private static User ELENA;
  private final String NEW_USER_ALBERT = "Albert";
  private final String NEW_USER_ELENA = "Elena";

  @BeforeEach
  public void createNewUser() {
    ALBERT = new User(NEW_USER_ALBERT);
    ELENA = new User(NEW_USER_ELENA);
  }

  @BeforeEach
  public void initOut() {
    out = new UserService(userDaoMock);
  }

  @Test
  void shouldFindUserBy() {
    when(userDaoMock.getUserByName(NEW_USER_ALBERT)).thenReturn(ALBERT);
    assertTrue(out.checkUserExist(ALBERT));
  }

  @Test
  void shouldReturnNullIfUserNotExist() {
    when(userDaoMock.getUserByName(NEW_USER_ELENA)).thenReturn(null);
    assertFalse(out.checkUserExist(ELENA));
  }
}