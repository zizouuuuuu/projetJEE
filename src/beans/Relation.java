package beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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

	public List<User> getRelations() {
		return relations;
	}

	public void setRelations(List<User> relations) {
		this.relations = relations;
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
	}
	
	public String addRelation() {
		
		return "";
	}
}
