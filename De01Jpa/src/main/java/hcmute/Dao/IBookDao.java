package hcmute.Dao;

import java.util.List;

import hcmute.Entity.Book;
import hcmute.Model.BookRating;

public interface IBookDao {
	List<Book> findAll();

	Book findOne(int bookid);

	void update(Book book);

	void delete(int bookid);

	Long countAll();

	List<Book> paginationPage(int index, int numberOfPage);

	List<Book> findBookByAuthor(int author_id);

	List<BookRating> findAll_DESC();

	void insert(Book book);

}
