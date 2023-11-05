package hcmute.Dao;

import java.util.List;

import hcmute.Entity.Author;
import hcmute.Model.AuthorBook;
import hcmute.Model.Book;

public interface IAuthorDao {
	public void insert(Author author); 
	public void update(Author author); 
	public void delete(int author_id); 
	public List<Author> paginationPage(int index, int numberOfPage); 
	public Long countAll ();
	Author findOne(int author_id);	
	public List<Book> findBookByAuthorId(int author_id);
	List<Author> findAll();
	List<AuthorBook> NumberOfBook();
}
