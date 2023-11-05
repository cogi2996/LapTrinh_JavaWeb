package hcmute.Service;

import java.util.List;

import hcmute.Dao.BookDaoImpl;
import hcmute.Dao.IBookDao;
import hcmute.Entity.Book;
import hcmute.Model.BookRating;


public class BookServiceimpl implements IBookService{
	IBookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findOne(int bookid) {
		// TODO Auto-generated method stub
		return bookDao.findOne(bookid);
	}

	@Override
	public void update(Book book) {
		// chỉnh sữa trường hợp book không đủ field từ form
		bookDao.update(book);
	}

	@Override
	public void delete(int bookid) {
		bookDao.delete(bookid);
	}

	@Override
	public Long countAll() {
		return bookDao.countAll();
	}

	@Override
	public List<Book> paginationPage(int index, int numberOfPage) {
		return bookDao.paginationPage(index, numberOfPage);
	}

	@Override
	public List<Book> findBookByAuthor(int author_id) {
		// TODO Auto-generated method stub
		return bookDao.findBookByAuthor(author_id);
	}

	@Override
	public List<BookRating> findAll_DESC() {
		// TODO Auto-generated method stub
		return bookDao.findAll_DESC();
	}

	@Override
	public void insert(Book book) {
		bookDao.insert(book);
		
	}

}
