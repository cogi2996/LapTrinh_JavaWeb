package hcmute.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.Entity.User;
import hcmute.JpaConfig.JPAConfig;
import hcmute.Model.Video;

public class UserDaoImpl implements IUserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<User> findAll() {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String username) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		return entityManager.find(User.class, username);
	}

	@Override
	public void update(User user) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(String username) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			User user = entityManager.find(User.class, username);
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

	@Override
	public Long countAll() {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM User u", Long.class);
		return query.getSingleResult();
	}

	@Override
	public List<User> paginationPage(int index, int numberOfPage) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
		query.setFirstResult(index * numberOfPage);
		query.setMaxResults(numberOfPage);
		return query.getResultList();
	}

	@Override
	public void insert(User user) {
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

	/*
	 * EntityManager entityManager = JPAConfig.getEntityManager(); TypedQuery<User>
	 * query =
	 * entityManager.createQuery("SELECT u FROM User u where u.username = :username"
	 * , User.class); query.setParameter("username", username); return
	 * query.getSingleResult().getVideos();
	 */
	@Override
	public List<Video> listLikedVideo(String username) {
		String sql = "SELECT f.* FROM Videos v JOIN Favorites f ON v.VideoId = f.VideoId WHERE f.Username = ?";
		List<Video> list = new ArrayList<Video>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			System.out.println("video here");
			while (rs.next()) {
				Video video = new Video(rs.getInt(1), rs.getDate(2));
				list.add(video);
				System.out.println(video);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;

	}

	@Override
	public List<User> findUser(String input) {
	    EntityManager entityManager = JPAConfig.getEntityManager();

	    TypedQuery<User> query = entityManager.createQuery(
	            "SELECT u FROM User u WHERE u.username LIKE :input OR u.email LIKE :input", User.class);
	    query.setParameter("input", "%" + input + "%");

	    List<User> users = query.getResultList();
	    entityManager.close();
	    return users;
	}
}
