package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import dbconnect.RelationDaoMysql;
import model.RelationM;
import model.User;

@Named
@RequestScoped
public class Relation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7360585484540282443L;

	int idUser1, idUser2;
	
	List<User> relations;
	RelationDaoMysql r = new RelationDaoMysql();
	@PostConstruct
    public void init() {
		
		this.idUser1 = (int) FacesContext.getCurrentInstance().getExternalContext()
		        .getSessionMap().get("idUser");
		this.relations = r.getAll(idUser1);
	}

	public List<User> getRelations() {
		return relations;
	}

	public void setRelations(List<User> relations) {
		this.relations = relations;
	}

	public int getIdUser1() {
		return idUser1;
	}

	public void setIdUser1(int idUser) {
		this.idUser1 = idUser;
	}
	
	
	public int getIdUser2() {
		return idUser2;
	}

	public void setIdUser2(int idUser2) {
		this.idUser2 = idUser2;
	}
	

	public String addRelation() {
		this.idUser1 = (int) FacesContext.getCurrentInstance().getExternalContext()
		        .getSessionMap().get("idUser");
		/*
		 * HttpServletRequest request = (HttpServletRequest)
		 * FacesContext.getCurrentInstance().getExternalContext() .getRequest();
		 * this.idUser2 = Integer.parseInt(request.getParameter("idUser2"));
		 */
		RelationM relation = new RelationM(idUser1, idUser2);
		r.addRelationDb(relation);
		return "success";
	}
}
