package hcmute.Service;

import java.util.List;

import hcmute.Dao.AuthorDaoImpl;
import hcmute.Dao.IAuthorDao;
import hcmute.Entity.Author;

public class AuthorServiceImpl implements IAuthorService {
	IAuthorDao authorDao = new AuthorDaoImpl();
	@Override
	public List<Author> findAll() {
		
		return authorDao.findAll();
	}

}
