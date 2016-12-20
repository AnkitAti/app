package com.app.factory.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
@NamedQueries ({
		@NamedQuery(
				name	= "getUserWithUsername",
				query	= "FROM User u WHERE u.username = :username"
		),
		@NamedQuery(
				name	= "getUserWithUsernameOrEmail",
				query	= " FROM User u WHERE u.username = :username OR u.email = :email"
		)
})
public class User implements Serializable {
	static final long serialVersionUID = 5397063106608308168L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="salt")
	private String salt;
	
	@Column(name="type")
	private String type;
	
	@Column(name="active")
	private String active;
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setId(int id) {
		this.id = (long)id;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSalt() {
		return this.salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getActive() {
		return this.active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
