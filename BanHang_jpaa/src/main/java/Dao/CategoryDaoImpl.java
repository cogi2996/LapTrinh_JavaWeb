package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.commons.collections.bag.TypedBag;

import JPAConfig.JPAConfig;
import entity.Category;


public class CategoryDaoImpl implements ICategoryDao {

	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		System.out.println("Bắt đầu insert");
		try {
			trans.begin();
			System.out.println("category in dao insert : " + category);
			enma.persist(category);

			trans.commit();
		} catch (Exception e) {
			System.out.println("lỗi ở dao rồi ");
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int cateid) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findById(int cateid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findByCategoryname(String catename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
	
		List<Category> categories = categoryDao.findAll();

		// In ra danh sách các category
		for (Category category : categories) {
			System.out.println(category);
		}
	}

}
