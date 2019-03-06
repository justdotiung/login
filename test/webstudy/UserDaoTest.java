package webstudy;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import user.db.UserDao;

public class UserDaoTest {
	
	
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
		dao.insert(UserTest.TEST_USER);
		
	}
}
