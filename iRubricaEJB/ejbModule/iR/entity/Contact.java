package iR.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Contact
 *
 */
@Entity
@Table(name="Contact")
@NamedQueries({
				@NamedQuery(name = "Contact.findById", query = "SELECT a FROM Contact a WHERE a.id = :id"),
				@NamedQuery(name = "Contact.findByName", query = "SELECT a FROM Contact a WHERE a.name = :name"),
				@NamedQuery(name = "Contact.findBySurname", query = "SELECT a FROM Contact a WHERE a.surname = :surname"),
				@NamedQuery(name = "Contact.findByCity", query = "SELECT a FROM Contact a WHERE a.city = :city"),
				@NamedQuery(name = "Contact.findByEmail", query = "SELECT a FROM Contact a WHERE a.email = :email"),
				@NamedQuery(name = "Contact.findAll", query = "SELECT a FROM Contact a"),
				@NamedQuery(name = "Contact.findByCombo", query = "SELECT a FROM Contact a WHERE a.name = :name AND a.surname = :surname AND a.email = :email AND a.tel_home = :tel_home"),
				@NamedQuery(name = "Contact.updateContact", query = "UPDATE Contact a SET a.name = :name, a.surname = :surname, a.tel_home = :tel_home, a.tel_office = :tel_office, a.mobile_tel = :mobile_tel, a.address_home = :address_home, a.address_office = :address_office, a.fax = :fax, a.insertDate = :insertDate, a.note = :note, a.idCreatore = :idCreatore, a.other = :other, a.web = :web, a.email = :email,a.city = :city,a.state = :state WHERE a.id = :id"),
				@NamedQuery(name = "Contact.searchForName", query = "SELECT a FROM Contact a WHERE UPPER(a.name) LIKE UPPER(:name) OR UPPER(a.surname) LIKE UPPER(:surname) "),
				@NamedQuery(name = "Contact.searchForEmail", query = "SELECT a FROM Contact a WHERE UPPER(a.email) LIKE UPPER(:email)"),
				@NamedQuery(name = "Contact.searchForPhone", query = "SELECT a FROM Contact a WHERE a.tel_home LIKE :tel_home OR a.tel_office LIKE :tel_office OR a.mobile_tel LIKE :mobile_tel OR a.fax LIKE :fax"),
})
				
public class Contact implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.AUTO )
	@Column(name = "id", nullable = false)	
	private Integer id = 0;
	
	
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	
	
	@Column(name = "surname", nullable = false, length = 30)
	private String surname;
	
	@Column(name = "tel_home", nullable = true)
	private String tel_home;
	
	@Column(name = "tel_office", nullable = true)
	private String tel_office;
	
	@Column(name = "mobile_tel", nullable = true)
	private String mobile_tel;
	
	@Column(name = "address_home", nullable = true)
	private String address_home;
	
	@Column(name = "address_office", nullable = true)
	private String address_office;
	
	@Column(name = "fax", nullable = true)
	private String fax;
	
	@Column(name = "email", nullable = true)
	private String email;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "insertDate", nullable = true)
	private Date insertDate;
	
	@Column(name = "note", nullable = true, length = 100)
	private String note;
	
	@Column(name = "idCreatore", nullable = true)
	private int idCreatore;
	
	@Column(name = "other", nullable = true)
	private String other;
	
	@Column(name = "web", nullable = true)
	private String web;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "state", nullable = true)
	private String state;

	
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}   
	public String getTel_home() {
		return this.tel_home;
	}

	public void setTel_home(String tel_home) {
		this.tel_home = tel_home;
	}   
	public String getTel_office() {
		return this.tel_office;
	}

	public void setTel_office(String tel_office) {
		this.tel_office = tel_office;
	}   
	public String getMobile_tel() {
		return this.mobile_tel;
	}

	public void setMobile_tel(String mobile_tel) {
		this.mobile_tel = mobile_tel;
	}   
	public String getAddress_home() {
		return this.address_home;
	}

	public void setAddress_home(String address_home) {
		this.address_home = address_home;
	}   
	public String getAddress_office() {
		return this.address_office;
	}

	public void setAddress_office(String address_office) {
		this.address_office = address_office;
	}   
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}  

	
	public Date getInsertDate() {
		return this.insertDate;
	}
	
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}   
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}   
	public int getIdCreatore() {
		return this.idCreatore;
	}

	public void setIdCreatore(int idCreatore) {
		this.idCreatore = idCreatore;
	}   
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}   
	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
