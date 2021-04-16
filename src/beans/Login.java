package beans;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dbconnect.UserDaoMysql;
import model.User;

@Named
@RequestScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7983763635844329642L;
	
	String username, password;

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
	
	
	public String signIn() {
		UserDaoMysql u = new UserDaoMysql();
		
		User user = u.login(username, password);
		int id = 0;
		//if(user != null) {
			id = user.getId();
		//}
			
		
		FacesContext.getCurrentInstance().getExternalContext()
        .getSessionMap().put("idUser", id);
		return user!=null ? "success" : "error";
	}

}

