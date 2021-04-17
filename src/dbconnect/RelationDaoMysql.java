package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Relation;
import model.RelationM;
import model.User;


public class RelationDaoMysql {
	
<<<<<<< HEAD
	//afficher des users avec qui on est pas en relation
=======
>>>>>>> d901fb57b5fafae59f00ac599a662f012e805993
	public ArrayList<User> getAll(int idUser){
		ArrayList<User> a = new ArrayList<>();
		Connection connection = DbConnection.getInstance();
		
		try {
<<<<<<< HEAD
			PreparedStatement ps;			
				ps = connection.prepareStatement("SELECT * FROM user WHERE id not in (SELECT id_user_1 from relation where id_user_1 = ?)"
						+ "and id not in (SELECT id_user_2 from relation where id_user_1 = ?)");
				ps.setInt(1, idUser);
				ps.setInt(2, idUser);
				 
				ResultSet r = ps.executeQuery();
				User user;
				
				while(r.next()) {
					user = new User();
					user.setFirstname(r.getString("firstname"));
					user.setLastname(r.getString("lastname"));
					user.setId(Integer.parseInt(r.getString("id")));
					a.add(user);
					}
				
				r.close();
			
			r.close();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
	//afficher les relations en commun avec un certain user
	public ArrayList<User> getCommonRelation(int idUser1, int idUser2){
		ArrayList<User> a = new ArrayList<>();
		Connection connection = DbConnection.getInstance();
		
		try {
			PreparedStatement ps;			
				ps = connection.prepareStatement("SELECT * FROM user WHERE id in (SELECT id_user_2 from relation where id_user_1 = ?)"
						+ "and id in (SELECT id_user_2 from relation where id_user_1 = ?)");
				ps.setInt(1, idUser1);
				ps.setInt(2, idUser2);
				 
				ResultSet r = ps.executeQuery();
				User user;
				
				while(r.next()) {
					user = new User();
					user.setFirstname(r.getString("firstname"));
					user.setLastname(r.getString("lastname"));
					user.setId(Integer.parseInt(r.getString("id")));
					a.add(user);
					}
				
				r.close();
=======
			PreparedStatement ps;
			ps = connection.prepareStatement("SELECT * FROM user WHERE id != ?");
			ps.setString(1, String.valueOf(idUser));
			ResultSet r = ps.executeQuery();
			
			User user = new User();
			
			while(r.next()) {
				user.setFirstname(r.getString("firstname"));
				user.setLastname(r.getString("lastname"));
				user.setId(Integer.parseInt(r.getString("id")));
				a.add(user);
			}
>>>>>>> d901fb57b5fafae59f00ac599a662f012e805993
			
			r.close();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
<<<<<<< HEAD
	//afficher mes relations
=======
>>>>>>> d901fb57b5fafae59f00ac599a662f012e805993
	public ArrayList<User> getMyRelation(int idUser){
		ArrayList<User> a = new ArrayList<>();
		Connection connection = DbConnection.getInstance();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user where"
					+ "id = (select * from relation where id_user_1 = ? or id_user_1 = 2)");
			ps.setString(1, String.valueOf(idUser));
			ps.setString(2, String.valueOf(idUser));
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
	
<<<<<<< HEAD
	//ajouter une relation
=======
>>>>>>> d901fb57b5fafae59f00ac599a662f012e805993
	public String addRelationDb(RelationM relation) {
		Connection connection = DbConnection.getInstance();
		
		try {
			PreparedStatement exist;
			exist = connection.prepareStatement("SELECT * from relation where id_user_1=? AND id_user_2=? OR id_user_1 = ? AND id_user_2=?");
			exist.setInt(1, relation.getIdUser1());
			exist.setInt(2, relation.getIdUser2());
			exist.setInt(3, relation.getIdUser2());
			exist.setInt(4, relation.getIdUser1());
			ResultSet r = exist.executeQuery();
			
			if(r.next()) {
				return "error";
			}
			PreparedStatement ps = connection.prepareStatement("Insert into relation values(?,?)");
			ps.setInt(1, relation.getIdUser1());
			ps.setInt(2, relation.getIdUser2());
			ps.execute();
			
			ps.close();
			return "success";
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "error";
	}
	
<<<<<<< HEAD
	//supprimer une relation
=======
>>>>>>> d901fb57b5fafae59f00ac599a662f012e805993
	public void deleteRelationDb(RelationM relation) {
		Connection connection = DbConnection.getInstance();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM relation VALUES(?,?)");
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
