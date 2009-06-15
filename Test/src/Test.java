

import iR.entity.Contact;
import iR.entityManager.ContactManagerRemote;

import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Test {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		prop.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		prop.put("java.naming.provider.url", "localhost:1099");
		Context context;
		
		try{
			context =new InitialContext(prop);
			
		ContactManagerRemote bean = (ContactManagerRemote) context.lookup("iRubrica/ContactManager/remote");
			
		Date date = new Date();
		date.setTime(0);
		
			bean.addContact( "prova", "prova","prova","prova","prova","prova","prova","prova",date,"prova",2,"prova","prova","prova","prova");
			System.out.println("add ok");
			Contact ct = new Contact();

		
			ct = bean.searchUserForName("prova");
			System.out.println("name "+ct.getName()+ " " +ct.getIdCreatore() + " "+ct.getInsertDate());
			
		}catch(NamingException e){
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
