package hcmute.Service;

import java.util.List;

import hcmute.Dao.BookDaoImpl;
import hcmute.Model.Book_21110709;
import hcmute.Model.User_21110709;



public class BookServiceImpl_21110709 implements IBookService_21110709 {
	
	
	@Override
	public List<Book_21110709> findAll() {
		// TODO Auto-generated method stub
		return new BookDaoImpl().findAll();
	}

	@Override
	public Book_21110709 findOne(int bookid) {
		// TODO Auto-generated method stub
		return new BookDaoImpl().findOne(bookid);
	}

	@Override
	public List<User_21110709> BookReview(int bookid) {
		// TODO Auto-generated method stub
		return new BookDaoImpl().BookReview(bookid);
	}

}
