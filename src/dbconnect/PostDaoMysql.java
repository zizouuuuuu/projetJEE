package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.PostM;

public class PostDaoMysql  {

	public ArrayList<PostM> getAllPosts(){
		ArrayList<PostM> a = new ArrayList<>();
		Connection connection = DbConnection.getInstance();
		Statement stmt;
		
		try {
			stmt = connection.createStatement();
			PreparedStatement ps;
			ps = connection.prepareStatement("Select * from post where  ");
			ps.setString(1, username);
		    ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
