package org.mda.export;

import java.util.Collection;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

import org.eclipse.e4.core.di.annotations.Creatable;

@Creatable
public class MailingAdapter {
	
	/**
	 * mail the list of messages
	 * @param messages  list of messages to be mailed
	 * @return list of messages, which could not be mailed due to an error
	 * @throws MessagingException Exception is thrown at a send error
	 */
	public void mail (final Collection <Message> messages) throws MessagingException {
		for (Message nextMessage : messages) {
			Transport.send(nextMessage);
		}
	}

}
