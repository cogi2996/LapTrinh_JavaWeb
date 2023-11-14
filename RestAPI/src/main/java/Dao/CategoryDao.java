package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JpaConfig.JPAConfig;
import Model.CategoryModel;

public class CategoryDao {
	public void insert(CategoryModel user) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
	public void update(CategoryModel cate) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(cate);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
	public void delete(int id) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			CategoryModel user = entityManager.find(CategoryModel.class, id);
			if (user != null) {
				entityManager.remove(user);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
	public List<CategoryModel> findAll() {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<CategoryModel> query = entityManager.createNamedQuery("CategoryModel.findAll", CategoryModel.class);
		return query.getResultList();
	}


}
