package hcmute.Dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.Entity.User;
import hcmute.JpaConfig.JPAConfig;

public class UserDaoImpl implements IUserDao {
	
	
	
	@Override
	public void insert(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}

	}

	@Override
	public void update(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}

	}

	@Override
	public void delete(int userid) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User user = enma.find(User.class, userid);
			if (user != null) {
				enma.remove(user);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			enma.close();
		}


	}

	@Override
	public List<User> paginationPage(int index, int numberOfPage) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> list  = enma.createQuery("select u from User u",User.class);
		list.setFirstResult(index*numberOfPage);
		list.setMaxResults(numberOfPage);
		return list.getResultList();

	}

	@Override
	public Long countAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Long> count = enma.createQuery("select count(b) from User b", Long.class);
		return count.getSingleResult();

	}
	@Override
	public User findOne(int userid) {
		EntityManager enma = JPAConfig.getEntityManager();
		User user = enma.find(User.class, userid);
		return user;
	}



}
