package com.ipl.dao.Impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.dao.UserDao;
import com.ipl.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		Session ses = sessionFactory.getCurrentSession();
		//Transaction tr = ses.beginTransaction();
		try {
			ses.save(user);
			//tr.commit();
		} catch (Exception e) {
			//tr.rollback();
			e.printStackTrace();
		}
	}
	
	public User authUser(String email, String password) {
		Session ses = sessionFactory.getCurrentSession();
		//select * from users where userName = '' and password = '';
		try {
			 Criteria cr = ses.createCriteria(User.class);
			 
			 User user = (User) cr.add( Restrictions.conjunction()
					 				.add( Restrictions.eq( "email", email ) )
					 				.add(Restrictions.eq( "password", password ))
					 			)
					 			.uniqueResult();
			 return user;
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	

}
