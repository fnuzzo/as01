package iR.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="USER")

public class User implements Serializable {

	
	private int id;
	private String username;
	private String mail;
	private String passwd;
	private String type;
	private static final long serialVersionUID = 1L;

	public User() {}
	

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO )
	public int getId() { 
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getUserName() {
		return this.username;
	}

	public void setUserName(String username) {
		this.username = username;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
