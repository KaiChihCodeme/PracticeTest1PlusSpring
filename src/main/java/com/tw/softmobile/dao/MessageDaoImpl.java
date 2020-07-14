package com.tw.softmobile.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.softmobile.model.Message;

@Service("messageDao")
public class MessageDaoImpl implements MessageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Message getMessage(Integer messageBookId) {
//		List<Message> list = sessionFactory.getCurrentSession()
//				.createQuery("select messageBody from message where messageBookId="+messageBookId).list();

		
		//				.get(Message.class, messageBookId);
//		return (Message)sessionFactory.openSession().createQuery("from message where messageBookId=" + messageBookId);
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createNativeQuery("select * " + 
				"from message where messageBookId=? order by timeStamp ASC;"
						, Message.class);
		query.setParameter(1, messageBookId);
		Iterator iterator = query.getResultList().iterator();	
		Message message = null;
		while (iterator.hasNext()) {
			message = (Message) iterator.next();
			System.out.println("sddjsijd" + message.getMessageBody());
		}
		return message;
	
	}
}
