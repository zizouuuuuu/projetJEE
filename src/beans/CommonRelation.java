package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dbconnect.RelationDaoMysql;
import model.User;


@Named
@RequestScoped
public class CommonRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6149218787583309839L;
	
	int idUser1, idUser2;
	
	List<User> relations;
	RelationDaoMysql r = new RelationDaoMysql();
	@PostConstruct
    public void init() {
		this.idUser1 = (int) FacesContext.getCurrentInstance().getExternalContext()
		        .getSessionMap().get("idUser");
		
		this.idUser2 = (int) FacesContext.getCurrentInstance().getExternalContext()
		        .getSessionMap().get("idUser2");
		this.relations = r.getCommonRelation(idUser1, idUser2);
	}
	public int getIdUser1() {
		return idUser1;
	}
	public void setIdUser1(int idUser1) {
		this.idUser1 = idUser1;
	}
	public int getIdUser2() {
		return idUser2;
	}
	public void setIdUser2(int idUser2) {
		this.idUser2 = idUser2;
		FacesContext.getCurrentInstance().getExternalContext()
        .getSessionMap().put("idUser2", this.idUser2);
	}
	public List<User> getRelations() {
		return relations;
	}
	public void setRelations(List<User> relations) {
		this.relations = relations;
	}
	
	

}
