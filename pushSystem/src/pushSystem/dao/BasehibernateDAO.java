package pushSystem.dao;

import org.hibernate.Session;

import pushSystem.factory.HibernateSessionFactory;

/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BasehibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		//FIXME: Implement this method
		return HibernateSessionFactory.getSession();
	}
	
}