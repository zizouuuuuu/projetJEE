package authentification;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dbconnect.UserDaoMysql;

@Named
@RequestScoped
public class Register implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 964794073748929712L;
	
	private String username, password, firstname, lastname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	public String signUp() {
		UserDaoMysql u = new UserDaoMysql();
		
		String s = u.registe(username, password, firstname, lastname);
		return s;
	}
	

}
