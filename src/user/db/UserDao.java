package user.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
}
