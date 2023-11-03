package hcmute.vn.Dao;

import java.util.List;

import hcmute.vn.Model.Book;


public interface IBookDao {
	List<Book> findAll ();
	Book findOne(int bookid);
	void update(Book book);
	void delete(int bookid);
	int countAll();
	List<Book> paginationPage(int index, int numberOfPage);
	List<Book> findBookByAuthor(int author_id);
	List<Book> findAll_DESC();
}