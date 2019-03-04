package user.db;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String userId;
	private String userPW;
	private String userName;
	private String userEmail;
	
	
	
	public User() {
	}



	public User(String userId, String userPw, String userName, String userEmail) {
	this.userId = userId;
	this.userPW = userPw;
	this.userName = userName;
	this.userEmail = userEmail;
	}



	public String getUserId() {
		return userId;
	}



	public String getUserPW() {
		return userPW;
	}



	public String getUserName() {
		return userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void create(User user) {
		Map<String, User> map= new HashMap<String, User>();
		map.put("userId", user);
		
	}
	
}
