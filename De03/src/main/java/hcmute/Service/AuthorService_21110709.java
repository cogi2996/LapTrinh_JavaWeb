package hcmute.Service;

import java.util.List;

import hcmute.Dao.IAuthorDao_21110709;
import hcmute.Dao.AuthorDaoImpl_21110709;
import hcmute.Model.Author_21110709;
import hcmute.Model.AuthorBook_21110709;
import hcmute.Model.Book_21110709;

public class AuthorService_21110709 implements IAuthorService_21110709 {

    private IAuthorDao_21110709 authorDao = new AuthorDaoImpl_21110709();

    @Override
    public void insert(Author_21110709 author) {
        authorDao.insert(author);
    }

    @Override
    public void update(Author_21110709 author) {
        authorDao.update(author);
    }

    @Override
    public void delete(int authorId) {
        authorDao.delete(authorId);
    }

    @Override
    public List<Author_21110709> paginationPage(int index, int numberOfPage) {
        return authorDao.paginationPage(index, numberOfPage);
    }

    @Override
    public Long countAll() {
        return authorDao.countAll();
    }

    @Override
    public Author_21110709 findOne(int author_id) {
        return authorDao.findOne(author_id);
    }

	

	@Override
	public List<Author_21110709> findAll() {
		// TODO Auto-generated method stub
		return authorDao.findAll();
	}

	@Override
	public List<AuthorBook_21110709> NumberOfBook() {
		// TODO Auto-generated method stub
		return authorDao.NumberOfBook();
	}
}
