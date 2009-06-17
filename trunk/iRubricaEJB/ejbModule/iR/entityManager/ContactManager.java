package iR.entityManager;

import iR.entity.Contact;
import iR.entity.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Session Bean implementation class ContactManager
 */

@Stateless
public class ContactManager implements ContactManagerLocal {
	
	
	
	@PersistenceContext (unitName = "iRubricaEJB")
 	private EntityManager em;
	
    public ContactManager() {}

  

	public void addContact(String name, String surname, String tel_home, String tel_office, String mobile_tel, 
							String address_home, String address_office,String fax, String mail, Date insertDate, 
							String note, int idCreatore, String other, String web, String city, String state) {
		
		
			Contact ct = new Contact();
					
					ct.setName(name);
					ct.setSurname(surname);
					ct.setTel_home(tel_home);
					ct.setTel_office(tel_office);
					ct.setAddress_home(address_home);
					ct.setAddress_office(address_office);
					ct.setFax(fax);
					ct.setEmail(mail);
					ct.setInsertDate(insertDate);
					ct.setNote(note);
					ct.setIdCreatore(idCreatore);
					ct.setOther(other);
					ct.setWeb(web);
					ct.setCity(city);
					ct.setState(state);

					em.persist(ct);	
		}

	
	public Contact findById(int value){		
			Contact contact = em.find(Contact.class, value);
			return contact;
			}
	
	public List<Contact> findByName(String name) {
		Query qe = em.createNamedQuery("Contact.findByName");
		qe.setParameter("name", name );
		List <Contact> l =  qe.getResultList();
		
		return l;
	}
	
	public List<Contact> findBySurname(String surname) {
		Query qe = em.createNamedQuery("Contact.findBySurname");
		qe.setParameter("surname",surname );
		List <Contact> l =  qe.getResultList();
		
		return l;
	}
	

	public List<Contact> ListAll() {
		Query all =em.createQuery("from Contact order by surname");
		List l = all.getResultList();
		return l;
	}



	public List<Contact> findByEmail(String email) {
		Query qe = em.createNamedQuery("Contact.findByEmail");
		qe.setParameter("email",email );
		List <Contact> l = qe.getResultList();
		
		return l;
	}







	
	
	
	
	


	



}
