package hcmute.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.Entity.Author;
import hcmute.Entity.Book;
import hcmute.JpaConfig.JPAConfig;
import hcmute.Model.BookRating;

public class BookDaoImpl implements IBookDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static void main(String[] args) {
		IBookDao bookDao = new BookDaoImpl();
		List<Book> list = bookDao.paginationPage(1,3);
		for(Book book : list) {
			System.out.println(book);
		}
//		System.out.println(bookDao.countAll());
	}

	@Override
	public List<Book> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Book> query = enma.createNamedQuery("Book.findAll", Book.class);
		return query.getResultList();
	}

	@Override
	public Book findOne(int bookid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Book book = enma.find(Book.class, bookid);
		return book;
	}

	@Override
	public void update(Book book) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(book);
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
	public void delete(int bookid) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Book book = enma.find(Book.class, bookid);
			if (book != null) {
				enma.remove(book);
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
	public Long countAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Long> count = enma.createQuery("select count(b) from Book b", Long.class);
		return count.getSingleResult();
	}

	@Override
	public List<Book> paginationPage(int index, int numberOfPage) {
		/*
		 * List<Book> result = new ArrayList<Book>(); String sql =
		 * "SELECT * FROM books\r\n" + "ORDER BY bookid\r\n" + "LIMIT ? OFFSET ?;"; try
		 * { conn = new DBConnection().getConnection(); PreparedStatement ps =
		 * conn.prepareStatement(sql);
		 * 
		 * ps.setInt(1, numberOfPage); ps.setInt(2, index * numberOfPage); ResultSet rs
		 * = ps.executeQuery(); Book book; while (rs.next()) { book = new Book();
		 * book.setBookid(rs.getInt("bookid"));
		 * book.setDescription(rs.getString("description"));
		 * book.setCover_image(rs.getString("cover_image"));
		 * book.setPrice(rs.getInt("price"));
		 * book.setPublisher(rs.getString("publisher"));
		 * book.setIsbn(rs.getInt("isbn")); book.setQuantity(rs.getInt("quantity"));
		 * book.setPublish_date(rs.getDate("publish_date"));
		 * book.setTitle(rs.getString("title")); result.add(book); } } catch (Exception
		 * e) { e.printStackTrace(); }
		 */
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Book> list  = enma.createQuery("select b from Book b",Book.class);
		list.setFirstResult(index*numberOfPage);
		list.setMaxResults(numberOfPage);
		return list.getResultList();
	}

	@Override
	public List<Book> findBookByAuthor(int author_id) {
		EntityManager entityManager = JPAConfig.getEntityManager();

		TypedQuery<Author> query = entityManager.createQuery("SELECT a from Author a WHERE a.author_id = :authorId",
				Author.class);
		query.setParameter("authorId", author_id);

		List<Book> books = query.getSingleResult().getBooks();

		entityManager.close(); // Đảm bảo đóng EntityManager sau khi sử dụng
		return books;
	}

	@Override
	public List<BookRating> findAll_DESC() {
		String sql = "SELECT books.*,rating.rating\r\n" + "FROM books\r\n"
				+ "Inner JOIN rating ON books.bookid = rating.bookid\r\n" + "GROUP BY books.bookid,rating.rating\r\n"
				+ "ORDER BY AVG(rating.rating) DESC;";
		List<BookRating> list = new ArrayList<BookRating>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BookRating book = new BookRating();
				book.setBookid(rs.getInt("bookid"));
				book.setTitle(rs.getString("title"));
				book.setRating(rs.getInt("rating"));
				list.add(book);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}

	@Override
	public void insert(Book book) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(book);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

}
