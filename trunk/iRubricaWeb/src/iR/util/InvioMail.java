package iR.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Antoine
 *
 */
public class InvioMail {

	public static void invioEmail(String dest, String soggetto, String contenuto ) {
		
		//String smtp = "smtp.fastwebnet.it";

		//da shell ssh -L 25:smtp.cs.unibo.it:25 accalai@mimi.cs.unibo.it
		//String smtp="localhost";
		String smtp ="smtp.cs.unibo.it";
		String mit ="fnuzzo@cs.unibo.it";
		
		try {
			Properties props = System.getProperties();
			props.put( "mail.smtp.host", smtp );

			Session session = Session.getDefaultInstance( props );
			Message message = new MimeMessage( session );

			InternetAddress from = new InternetAddress( mit );
			InternetAddress to[] = InternetAddress.parse( dest );

			message.setFrom( from );
			message.setRecipients( Message.RecipientType.TO, to );
			message.setSubject( soggetto );
			message.setSentDate( new Date() );
			message.setText( contenuto );

			Transport.send(message);
	    } catch(MessagingException e) {
	    }
	    
	  }
}
