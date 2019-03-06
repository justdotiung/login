package user.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public Connection getconnection() {
		String id = "scott";
		String pw = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", id, pw);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insert(User user) {
		PreparedStatement ps = null;
		String query = "insert into usertbl values(?,?,?,?)";

		try {
			ps = getconnection().prepareStatement(query);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserPW());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getUserEmail());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String userId) {
		PreparedStatement pr = null;
		
		String query = "delete usertbl where userId =?";
		try {
			pr = getconnection().prepareStatement(query);
		
		
				pr.setString(1, userId);
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}

	public void modify(User user) {
PreparedStatement ps = null;
String query = "update usertbl set password = ? ,name = ? ,email = ? where userId =?";
 try {
	ps = getconnection().prepareStatement(query);
	ps.setString(1,user.getUserPW());
	ps.setString(2,user.getUserName());
	ps.setString(3,user.getUserEmail());
	ps.setString(4,user.getUserId());
	ps.executeUpdate();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	public void view(User testUser) {
		String query = "select * from userTbl where userId = ?";
		PreparedStatement pr = null;
		ResultSet rs = null;
		
		try {
			pr = getconnection().prepareStatement(query);
			rs = pr.executeQuery();
			if(rs.next()) {
				rs.getString("userId");
				rs.getString("password");
				rs.getString("name");
				rs.getString("email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
