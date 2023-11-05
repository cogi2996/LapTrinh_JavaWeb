package hcmute.Service;

import java.util.List;

import hcmute.Dao.IAuthorDao;
import hcmute.Dao.AuthorDaoImpl;
import hcmute.Entity.Author;
import hcmute.Model.AuthorBook;
import hcmute.Model.Book;

public class AuthorService implements IAuthorService {

    private IAuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public void insert(Author author) {
        authorDao.insert(author);
    }

    @Override
    public void update(Author author) {
        authorDao.update(author);
    }

    @Override
    public void delete(int authorId) {
        authorDao.delete(authorId);
    }

    @Override
    public List<Author> paginationPage(int index, int numberOfPage) {
        return authorDao.paginationPage(index, numberOfPage);
    }

    @Override
    public Long countAll() {
        return authorDao.countAll();
    }

    @Override
    public Author findOne(int author_id) {
        return authorDao.findOne(author_id);
    }

	@Override
	public List<Book> findBookByAuthorId(int author_id) {
		// TODO Auto-generated method stub
		return authorDao.findBookByAuthorId(author_id);
	}

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return authorDao.findAll();
	}

	@Override
	public List<AuthorBook> NumberOfBook() {
		// TODO Auto-generated method stub
		return authorDao.NumberOfBook();
	}
}
