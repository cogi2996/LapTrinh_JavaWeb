package hcmute.vn.Service;

import java.util.List;

import hcmute.vn.Dao.BookDaoImpl;
import hcmute.vn.Dao.IBookDao;
import hcmute.vn.Model.Book;

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
	public int countAll() {
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
	public List<Book> findAll_DESC() {
		// TODO Auto-generated method stub
		return bookDao.findAll_DESC();
	}

	@Override
	public void insert(Book book) {
		bookDao.insert(book);
		
	}

}
