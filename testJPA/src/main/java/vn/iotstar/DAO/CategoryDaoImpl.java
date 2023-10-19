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

	public static void main(String[] args) {
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		Category cate = new Category();
		cate.setCategoryName("haha");
		cate.setIcon("hihi");
		categoryDao.insert(cate);
		// Gọi phương thức findall để lấy danh sách các category
		List<Category> categories = categoryDao.findAll();

		// In ra danh sách các category
		for (Category category : categories) {
			System.out.println(category);
		}
	}

}
