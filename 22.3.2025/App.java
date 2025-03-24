package com.project.HibernateProject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args){
    	Contact contact= new Contact("1234567555","Chennai","Tamil Nadu",600004);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Contact.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(contact);
		tx.commit();
		
		session.close();

    }
}
