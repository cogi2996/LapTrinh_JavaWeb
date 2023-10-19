package vn.iotstar.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JpaConfig {
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BanHang");
		return factory.createEntityManager();

	}
	 public static void main(String[] args) {
	        EntityManager entityManager = JpaConfig.getEntityManager();

	        try {
	            // Thử kết nối đến cơ sở dữ liệu
	            entityManager.getTransaction().begin();
	            System.out.println("Kết nối đến cơ sở dữ liệu thành công.");
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
	            if (entityManager.getTransaction().isActive()) {
	                entityManager.getTransaction().rollback();
	            }
	        } finally {
	            entityManager.close();
	        }
	    }
}
