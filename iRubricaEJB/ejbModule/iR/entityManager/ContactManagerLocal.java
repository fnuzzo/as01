package iR.entityManager;
import iR.entity.Contact;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface ContactManagerLocal {

	void addContact(String name, String surname, 
			String tel_home, String tel_office, 
			String mobile_tel, String address_home, 
			String address_office, String fax,String mail, Date insertDate, 
			String note, int idCreatore, String other, String web,
			String city, String state);


		Collection<Contact> ListAll ();


		Contact searchUserForName(String name);

			
			
			Contact contactFindById(int value);
			
			List contactFindByName(String value);
			

}
