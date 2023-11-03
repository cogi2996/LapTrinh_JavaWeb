package hcmute.vn.Service;

import java.util.List;

import hcmute.vn.Dao.AuthorDaoImpl;
import hcmute.vn.Dao.IAuthorDao;
import hcmute.vn.Model.Author;

public class AuthorSeriveImpl implements IAuthorService{
	IAuthorDao authorDao = new AuthorDaoImpl();
	@Override
	public List<Author> findAll() {
		return authorDao.findAll();
	}
	
	
	
}
