package dbconnect;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import dbconnect.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoMysql {
	private static String GET_USERS_SQL = "SELECT id, firstname, lastname FROM user";
	
	
	
	public List<User> findAll()
	{
		List<User> users = new ArrayList<User>();
		Connection connection = DbConnection.getInstance();
		Statement stmt;

		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_USERS_SQL);
			
			// Loop over the database result set and create the
			// user objects.
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setFirstname(rs.getString("firstname"));
				u.setLastname(rs.getString("lastname"));
				users.add(u);
			}
			// Free resources
			rs.close();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return users;
	}
	
	public User login(String username, String password) {
		User user = new User();
		Connection connection = DbConnection.getInstance();
		Statement stmt;
		
		try {
			stmt = connection.createStatement();
			PreparedStatement ps;
			ps = connection.prepareStatement("Select * from user where username=? and password=?");
			ps.setString(1, username);
		    ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			
			// Loop over the database result set and create the
			// user objects.
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
			}
			// Free resources
			rs.close();
			ps.close();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return user;
	}
	
	public String registe(String username, String password, String firstname, String lastname) {
		Connection connection = DbConnection.getInstance();
		Statement stmt;
		try {
			stmt = connection.createStatement();
			
			PreparedStatement ps = connection.prepareStatement("INSERT into user values(?,?,?,?)");
			ps.setString(1, username);
		    ps.setString(2, password);
		    ps.setString(3, firstname);
		    ps.setString(4, lastname);
			ps.execute();
			
			// Loop over the database result set and create the
			// user objects.
			
			// Free resources
			ps.close();
			stmt.close();
			return "seccess";
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return "error";
	}
	
}
