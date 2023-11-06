package hcmute.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAConfig {
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("videoJpa");
		return factory.createEntityManager();

	}

	public static void main(String[] args) {
		EntityManager entityManager = JPAConfig.getEntityManager();

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
