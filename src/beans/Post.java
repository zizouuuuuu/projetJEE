package beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dbconnect.PostDaoMysql;
import dbconnect.RelationDaoMysql;
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
	
	List<PostM> posts ;
	
	@PostConstruct
    public void init() {
		PostDaoMysql p = new PostDaoMysql();
		this.posts = p.getAllPosts();
	}

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
		PostM p = new PostM();
		p.setContenu(contenu);
		this.idUser = (int) FacesContext.getCurrentInstance().getExternalContext()
		        .getSessionMap().get("idUser");
		
		p.setIdUser(idUser);
		PostDaoMysql d = new PostDaoMysql();
		d.addPostBD(p);
		return "success";
	}
}
