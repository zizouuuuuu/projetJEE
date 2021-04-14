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
			ps = connection.prepareStatement("Select * from post");
			ResultSet rs = ps.executeQuery();
			PostM post = new PostM();
			
			while (rs.next()) {
				post.setContenu(rs.getString("contenu"));
				post.setIdUser(Integer.parseInt(rs.getString("id_user")));
				a.add(post);
			}
			
			rs.close();
			ps.close();
			stmt.close();
			connection.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public void addPostBD(PostM post) {
		Connection connection = DbConnection.getInstance();
		
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement("insert into post (contenu, id_user) values (?, ?)");
			ps.setString(1, post.getContenu());
			ps.setString(2, String.valueOf(post.getIdUser()));
			
			ps.execute();
			
			ps.close();
			connection.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
