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
		User user = new User("uk","1234","king","king@king.com");		
		UserDb.addUser(user); 
		
		User dbUser = UserDb.findUser(user.getUserId());
		assertEquals(user ,dbUser);
	}
	@Test
	public void notUser() throws Exception {
		User dbUser = UserDb.findUser("userId");
		assertNull(dbUser);
	}
	
}
