package hcmute.Dao;

import java.util.List;

import hcmute.Model.Book_21110709;
import hcmute.Model.User_21110709;

public interface IBookDao_21110709 {
	List<Book_21110709> findAll();
	Book_21110709 findOne(int bookid);
	List<User_21110709> BookReview (int bookid);
}
