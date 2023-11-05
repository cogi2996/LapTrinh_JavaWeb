package hcmute.Service;

import java.util.List;

import hcmute.Entity.Author;
import hcmute.Model.AuthorBook;
import hcmute.Model.Book;

public interface IAuthorService {
	public void insert(Author author);

	public void update(Author author);

	public void delete(int authorId);

	public List<Author> paginationPage(int index, int numberOfPage);

	public Long countAll();

	Author findOne(int author_id);
	public List<Book> findBookByAuthorId(int author_id);
	List<Author> findAll();
	List<AuthorBook> NumberOfBook();
}
