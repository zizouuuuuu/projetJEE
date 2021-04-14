package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Relation;
import model.User;


public class RelationDaoMysql {
	
	public ArrayList<Object> getAll(){
		ArrayList<Object> a = new ArrayList<>();
		Connection connection = DbConnection.getInstance();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user where"
					+ "id = (select * from relation where id_user_1 = ? or id_user_1 = 2)");
			ResultSet r = ps.executeQuery();
			
			User user = new User();
			
			while(r.next()) {
				user.setFirstname(r.getString("firstname"));
				user.setLastname(r.getString("lastname"));
				user.setId(Integer.parseInt(r.getString("id")));
				a.add(user);
			}
			
			r.close();
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
	public void addRelationDb(Relation relation) {
		Connection connection = DbConnection.getInstance();
		
		try {
			PreparedStatement ps = connection.prepareStatement("insert into relation values(?,?)");
			ps.setString(1, String.valueOf(relation.getIdUser1()));
			ps.setString(2, String.valueOf(relation.getIdUser2()));
			ps.execute();
			
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRelationDb(Relation relation) {
		Connection connection = DbConnection.getInstance();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from relation values(?,?)");
			ps.setString(1, String.valueOf(relation.getIdUser1()));
			ps.setString(2, String.valueOf(relation.getIdUser2()));
			ps.execute();
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
