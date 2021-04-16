package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dbconnect.PostDaoMysql;
import dbconnect.UserDaoMysql;
import model.User;

@Named
@RequestScoped
public class ViewProfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4069753204679103836L;
	
	String firstname, lastname;
	int id;
	
	List<User> infos;
	@PostConstruct
    public void init() {
	
		UserDaoMysql user = new UserDaoMysql();
		this.infos = user.getInfos(id);
		
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
