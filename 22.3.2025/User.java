package com.project.HibernateProject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class User {
	
	@Id
	private int userid;
	private String username;
	private String email;
	private String userpass;

	public User() {

	}

	public User(int userid, String username, String email, String userpass) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.userpass = userpass;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", userpass=" + userpass+"]";
	}
	
}