package webstudy;

import static org.junit.Assert.*;

import org.junit.Test;

import user.db.NotFoundException;
import user.db.PasswordMismatch;
import user.db.User;
import user.db.UserDb;

public class UserTest {
static final User TEST_USER = new User("uk","1234","king","king@king.com");		

	@Test
	public void matchPw() throws Exception {
		assertTrue(TEST_USER.samePw("1234"));
	}
	@Test
	public void notMatchPw() throws Exception {
		assertFalse(TEST_USER.samePw("userPw2"));
	}
	
	@Test
	public  void login() throws Exception {
		User user = UserTest.TEST_USER;
		UserDb.addUser(user);
		assertTrue(user.login(TEST_USER.getUserId(),TEST_USER.getUserPW()));
	}
	@Test(expected = NotFoundException.class)
	public void notExistedUeser() throws Exception {
		TEST_USER.login("userId",TEST_USER.getUserPW());
		
	}
	@Test(expected = PasswordMismatch.class)
	public void pwNotMatch() throws Exception {
		User user = UserTest.TEST_USER;
		UserDb.addUser(user);
		TEST_USER.login(TEST_USER.getUserId(),"Pw");

	}

	
}
