package vn.iotstar.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Category;
import vn.iotstar.Entity.product;
import vn.iotstar.JpaConfig.JpaConfig;

public class ProductDaoImpl implements IProductDao {

	@Override
	public List<product> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<product> query = enma.createNamedQuery("product.findAll", product.class);
		return query.getResultList();
	}
	// 
	@Override
	public void insert(product pro) {
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		System.out.println("Bắt đầu insert");
		try {
			trans.begin();
			enma.persist(pro);
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
	///
	public static void main(String[] args) {
		IProductDao productDao = new ProductDaoImpl();
		product pro = new product();
		pro.setProductName("product01");
		
		Category cate = new Category();
		cate.setCategoryID(1);
		pro.setCategory(cate);
		
		productDao.insert(pro);
		// Gọi phương thức findall để lấy danh sách các category
		List<product> list = productDao.findAll();
		
		// In ra danh sách các category
		for (product item : list) {
			System.out.println(item);
		}
	}

}
