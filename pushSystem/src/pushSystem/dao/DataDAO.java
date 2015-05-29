package pushSystem.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Data
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pushSystem.dao.Data
 * @author MyEclipse Persistence Tools
 */
public class DataDAO extends BasehibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DataDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String PERFORMER = "performer";
	public static final String LABEL1 = "label1";
	public static final String LABEL2 = "label2";
	public static final String LABEL3 = "label3";
	public static final String DATA_VALUATION = "dataValuation";
	public static final String FEEDBACK_VALUA = "feedbackValua";
	public static final String ACCURATE_TIME = "accurateTime";

	public void save(Data transientInstance) {
		log.debug("saving Data instance");
		Transaction tx = getSession().beginTransaction(); 
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		tx.commit();
        getSession().flush();
        getSession().close();

	}

	public void delete(Data persistentInstance) {
		log.debug("deleting Data instance");
		Transaction tx = getSession().beginTransaction(); 
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		tx.commit();
        getSession().flush();
        getSession().close();
	}

	public Data findById(java.lang.String id) {
		log.debug("getting Data instance with id: " + id);
		try {
			Data instance = (Data) getSession().get("pushSystem.dao.Data", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Data instance) {
		log.debug("finding Data instance by example");
		try {
			List results = getSession().createCriteria("pushSystem.dao.Data")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Data instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Data as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByPerformer(Object performer) {
		return findByProperty(PERFORMER, performer);
	}

	public List findByLabel1(Object label1) {
		return findByProperty(LABEL1, label1);
	}

	public List findByLabel2(Object label2) {
		return findByProperty(LABEL2, label2);
	}

	public List findByLabel3(Object label3) {
		return findByProperty(LABEL3, label3);
	}

	public List findByDataValuation(Object dataValuation) {
		return findByProperty(DATA_VALUATION, dataValuation);
	}

	public List findByFeedbackValua(Object feedbackValua) {
		return findByProperty(FEEDBACK_VALUA, feedbackValua);
	}

	public List findByAccurateTime(Object accurateTime) {
		return findByProperty(ACCURATE_TIME, accurateTime);
	}

	public List findAll() {
		log.debug("finding all Data instances");
		try {
			String queryString = "from Data";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Data merge(Data detachedInstance) {
		log.debug("merging Data instance");
		try {
			Data result = (Data) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Data instance) {
		log.debug("attaching dirty Data instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Data instance) {
		log.debug("attaching clean Data instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}