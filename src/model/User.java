package model;


public class User {
	/**
	 * The user's identifier.
	 * 
	 * Primary key.
	 */
	private int id;
	
	/**
	 * The user's firstname.
	 */
	private String firstname;
	
	/**
	 * The user's lastname.
	 */
	private String lastname;

	public int getId() {
		return id;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public User setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public User setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	
}
