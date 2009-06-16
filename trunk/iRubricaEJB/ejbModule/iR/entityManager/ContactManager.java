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
public class ContactManager implements ContactManagerRemote, ContactManagerLocal {
	
	
	
	@PersistenceContext (unitName = "iRubricaEJB")
 	private EntityManager em;
	
    public ContactManager() {}

  

	public void addContact(String name, String surname, String tel_home,
			String tel_office, String mobile_tel, String address_home,
			String address_office, String fax, Date insertDate, String note,
			int idCreatore, String other, String web, String city,
			String state) {
		
		
		Contact ct = new Contact();
		ct.setName(name);
		ct.setSurname(surname);
		ct.setTel_home(tel_home);
		ct.setTel_office(tel_office);
		ct.setAddress_home(address_home);
		ct.setAddress_office(address_office);
		ct.setFax(fax);
		ct.setInsertDate(insertDate);
		ct.setNote(note);
		ct.setIdCreatore(idCreatore);
		ct.setOther(other);
		ct.setWeb(web);
		ct.setCity(city);
		ct.setState(state);

		em.persist(ct);
		
		
	}
/*
	public List UsersLike(String value){
		EntityManager em=emf.createEntityManager();
		Query q=em.createNamedQuery("Users.like");
		q.setParameter("name", value);
		List l=q.getResultList();
		return l;
		}
	
	*/
	
	

		
		
		
	
	public Contact contactFindById(int value){
			Query qe = em.createNamedQuery("Contact.findById");
			qe.setParameter("id", value );
			Contact c = (Contact) qe.getSingleResult();
			return c;
			}
	
	public List contactFindByName(String value){
		Query qe = em.createNamedQuery("Contact.findByName");
		qe.setParameter("name", value );
		List l = qe.getResultList();
		return l;
		}

	
	
	
	
	
	
	
	public Collection<Contact> ListAll() {
		Query all =em.createQuery("from Contact order by surname");
		return all.getResultList();
	}
	
	
	
	
	public Contact findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact searchUserForName(String name) {
		Contact contact = em.find(Contact.class, name);
		return contact;
	}

	



}
