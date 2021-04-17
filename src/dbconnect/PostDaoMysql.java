package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.PostM;

public class PostDaoMysql  {

	//recuperer tous les posts
	public ArrayList<PostM> getAllPosts(){
		
		//PostM model
		ArrayList<PostM> a = new ArrayList<>();
		Connection connection = DbConnection.getInstance();
		
		
		try {
			
			PreparedStatement ps;
			ps = connection.prepareStatement("SELECT * FROM post");
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) return null;
			while (rs.next()) {
				PostM post = new PostM();
				post.setContenu(rs.getString("contenu"));
				post.setIdUser(Integer.parseInt(rs.getString("id_user")));
				
				PreparedStatement sql;
				sql = connection.prepareStatement("SELECT * FROM user WHERE id=?");
				sql.setString(1, rs.getString("id_user"));
				ResultSet r = sql.executeQuery();
				
				while(r.next()) {
					post.setFirstname(r.getString("firstname"));
					post.setLastname(r.getString("lastname"));
				}
				
				a.add(post);
			}
			
			rs.close();
			ps.close();
						
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	//ajouter un post
	public String addPostBD(PostM post) {
		Connection connection = DbConnection.getInstance();
		
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement("INSERT into post (contenu, id_user) values (?,?)");
			ps.setString(1, post.getContenu());
			ps.setString(2, String.valueOf(post.getIdUser()));
			
			ps.execute();
			
			ps.close();
			return "success";
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "error";
	}
}
