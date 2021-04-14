package beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.PostM;


@Named
@RequestScoped
public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6580144606407750531L;

	
	Date date;
	Time heure;
	String contenu;
	int idUser;
	
	List<PostM> posts;

	public List<PostM> getPosts() {
		return posts;
	}

	public void setPosts(List<PostM> posts) {
		this.posts = posts;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getHeure() {
		return heure;
	}
	public void setHeure(Time heure) {
		this.heure = heure;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
	public String addPost() {
		
		return "";
	}
}
