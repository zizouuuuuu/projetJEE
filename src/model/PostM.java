package model;

import java.sql.Time;
import java.util.Date;

public class PostM {

	Date date;
	Time heure;
	String contenu;
	int idUser;
	String firstname, lastname;
	
	
	public PostM() {
		/*
		 * super(); this.date = date; this.heure = heure; this.contenu = contenu;
		 * this.idUser = idUser;
		 */
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
	
	
}
