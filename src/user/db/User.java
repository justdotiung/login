package user.db;


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



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public void setUserEmail(String userEmail) {
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



	public boolean samePw(String userPW2) {
	return this.userPW.equals(userPW2);
	}



	public Boolean unexedUser(String string) {

		return this.userId.equals(string);
	}



	public static boolean login(String userId2, String userPW2) throws NotFoundException, PasswordMismatch {
		User user = UserDb.findUser(userId2);
		
		if(user == null )
			throw new NotFoundException();
		if(!user.samePw(userPW2))
			throw new PasswordMismatch();
		
			return true;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPW=" + userPW + ", userName=" + userName + ", userEmail=" + userEmail
				+ "]";
	}












	
}
