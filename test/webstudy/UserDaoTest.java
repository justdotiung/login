package webstudy;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import user.db.User;
import user.db.UserDao;
import user.webstudy.Login;

public class UserDaoTest {
	final static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private UserDao dao;
	
	@Before
	public void setup() {
		dao = new UserDao();
		
	}
	@Test
	public void connectionDb() throws Exception {
		Connection con =dao.getconnection();
		assertNotNull(con);
	}
	@Test
	public void insert() throws Exception {
		dao.delete(UserTest.TEST_USER.getUserId());
		dao.insert(UserTest.TEST_USER);
		User user = UserTest.TEST_USER;
		user.setUserPW("123");
		logger.debug(user.toString());
		dao.modify(user);
		dao.view(UserTest.TEST_USER);
		
	}
}
