package hcmute.vn.Service;

import java.util.List;

import hcmute.vn.Dao.IUserDao;
import hcmute.vn.Dao.UserDaoImpl;
import hcmute.vn.Model.User;



public class UserServiceImpl implements IUserService{
	IUserDao userDao = new UserDaoImpl();
	@Override
	public List<User> paginationUser(int index, int numberOfPage) {
		return userDao.paginationUser(index, numberOfPage);
	}
	@Override
	public int countAll() {
		return userDao.countAll();
	}
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}
	
	
}
