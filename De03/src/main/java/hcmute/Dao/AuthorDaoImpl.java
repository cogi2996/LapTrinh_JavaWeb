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
import hcmute.JpaConfig.JPAConfig;
import hcmute.Model.AuthorBook;
import hcmute.Model.Book;

public class AuthorDaoImpl implements IAuthorDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(Author author) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(author);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void update(Author author) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(author);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(int author_id) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Author author = entityManager.find(Author.class, author_id);
			if (author != null) {
				entityManager.remove(author);
			} else {
				throw new Exception("Không tìm thấy");
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
	public List<Author> paginationPage(int index, int numberOfPage) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a", Author.class);
		query.setFirstResult(index * numberOfPage);
		query.setMaxResults(numberOfPage);
		return query.getResultList();
	}

	@Override
	public Long countAll() {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(a) FROM Author a", Long.class);
		return query.getSingleResult();
	}

	@Override
	public Author findOne(int author_id) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		return entityManager.find(Author.class, author_id);
	}

	@Override
	public List<Book> findBookByAuthorId(int author_id) {
		String sql = "SELECT\r\n"
				+ "  books.bookid\r\n"
				+ "FROM\r\n"
				+ "  books\r\n"
				+ "JOIN\r\n"
				+ "  book_authors\r\n"
				+ "ON\r\n"
				+ "  books.bookid = book_authors.bookid\r\n"
				+ "WHERE\r\n"
				+ "  book_authors.author_id = ?;";
		List<Book> list = new ArrayList<Book>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				list.add(book);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}
	@Override
	public List<Author> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Author> query = enma.createNamedQuery("Author.findAll", Author.class);
		return query.getResultList();
	}

	@Override
	public List<AuthorBook> NumberOfBook() {
		String sql = "SELECT author_id,COUNT(*) as count FROM book_authors group by author_id";
		List<AuthorBook> list = new ArrayList<AuthorBook>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AuthorBook authorBook  = new AuthorBook(rs.getInt(1),rs.getInt(2));
				list.add(authorBook);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}
	


}
