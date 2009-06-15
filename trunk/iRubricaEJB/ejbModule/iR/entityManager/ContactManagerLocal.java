package iR.entityManager;
import iR.entity.Contact;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Local;

@Local
public interface ContactManagerLocal {

	void addContact(String name, String surname, 
			String tel_home, String tel_office, 
			String mobile_tel, String address_home, 
			String address_office, String fax, Date insertDate, 
			String note, int idCreatore, String other, String web,
			String city, String state);


		Collection<Contact> ListAll ();


		Contact searchUserForName(String name);

			Contact findById(int id);

}
