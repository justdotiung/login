package webstudy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import user.db.User;
import user.db.UserDb;

public class Databasetest {

	@Test
	public void test() {
		UserDb.addUser(UserTest.TEST_USER); 
		
		User dbUser = UserDb.findUser(UserTest.TEST_USER.getUserId());
		assertEquals(UserTest.TEST_USER ,dbUser);
	}
	@Test
	public void notUser() throws Exception {
		User dbUser = UserDb.findUser("userId");
		assertNull(dbUser);
	}
	
}
