package vn.iotstar.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Category;
import vn.iotstar.JpaConfig.JpaConfig;

public class CategoryDaoImpl implements ICategoryDao {

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);

		return query.getResultList();
	}

	@Override
	public void insert(Category category) {
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		System.out.println("Bắt đầu insert");
		try {
			trans.begin();
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
	public void update(Category cate) {
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(cate);
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
	public void delete(int id) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Category category = enma.find(Category.class, id);
			if (category != null) {
				enma.remove(category);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}

	}
	
	

	public static void main(String[] args) throws Exception {
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		//Category cate = new Category(4, "dasua", "lala", null);
		//categoryDao.delete();
//		List<Category> categories = categoryDao.findAll();
//		
//		// In ra danh sách các category
//		for (Category category : categories) {
//			System.out.println(category);
//		}
		System.out.println(categoryDao.findById(2));
	}

	@Override
	public Category findById(int categoryId) {
		EntityManager enma = JpaConfig.getEntityManager();
		Category category = enma.find(Category.class,categoryId);
		return category;
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}
	

}
