package iR.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="User")

@NamedQueries({
				@NamedQuery(name = "User.findByUsername", query = "SELECT a FROM User a WHERE a.username = :username"),
				@NamedQuery(name = "User.findAll", query = "SELECT a FROM User a"),
				@NamedQuery(name = "User.updateUser", query = "UPDATE User a SET a.mail = :mail, a.passwd = :passwd WHERE a.username = :username"),
				@NamedQuery(name = "User.updateUserType", query = "UPDATE User a SET a.type = :type WHERE a.username = :username"),
				})




public class User implements Serializable {

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO )
	@Column(name = "id", nullable = true)
	private int id;
	
	
	@Column(name = "username", nullable = false, length = 30)
	private String username;
	
	@Column(name = "mail", nullable = false, length = 30)
	private String mail;
	
	@Column(name = "passwd", nullable = false, length = 30)
	private String passwd;
	
	@Column(name = "type", nullable = false, length = 30)
	private String type;
	
	private static final long serialVersionUID = 1L;

	public User() {}
	

	
	
	
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
