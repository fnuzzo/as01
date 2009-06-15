package iR.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

import com.sun.istack.Nullable;

/**
 * Entity implementation class for Entity: Contact
 *
 */
@Entity
@Table(name="CONTACT")

public class Contact implements Serializable {

	
	private int id;
	private String name;
	private String surname;
	private String tel_home;
	private String tel_office;
	private String mobile_tel;
	private String address_home;
	private String address_office;
	private String fax;
	private Date insertDate;
	private String note;
	private int idCreatore;
	private String other;
	private String web;
	private String city;
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

	
	public Contact() {
		super();
	}
	
	
	@GeneratedValue (strategy = GenerationType.AUTO )
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	 
	
	@Id
	@Column (nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	@Column (nullable = false, length = 30)
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
	
	@Column (nullable = false, length = 100)
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

	@Temporal(TemporalType.DATE)
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
	
}
