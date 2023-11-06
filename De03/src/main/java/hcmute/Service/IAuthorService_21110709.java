package hcmute.Service;

import java.util.List;

import hcmute.Model.Author_21110709;
import hcmute.Model.AuthorBook_21110709;
import hcmute.Model.Book_21110709;

public interface IAuthorService_21110709 {
	public void insert(Author_21110709 author);

	public void update(Author_21110709 author);

	public void delete(int authorId);

	public List<Author_21110709> paginationPage(int index, int numberOfPage);

	public Long countAll();

	Author_21110709 findOne(int author_id);
	List<Author_21110709> findAll();
	List<AuthorBook_21110709> NumberOfBook();
}
