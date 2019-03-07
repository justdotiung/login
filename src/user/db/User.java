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
	UserDao dao = new UserDao();
		User user = dao.view(userId2);
		
		if(user == null )
			throw new NotFoundException();
		if(!user.samePw(userPW2))
			throw new PasswordMismatch();
		
			return true;
	}

	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPW == null) ? 0 : userPW.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPW == null) {
			if (other.userPW != null)
				return false;
		} else if (!userPW.equals(other.userPW))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPW=" + userPW + ", userName=" + userName + ", userEmail=" + userEmail
				+ "]";
	}
}
