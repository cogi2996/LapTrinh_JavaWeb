package hcmute.Service;

import java.util.List;

import hcmute.Dao.IUserDao;
import hcmute.Dao.UserDaoImpl;
import hcmute.Entity.User;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int userid) {
		userDao.delete(userid);
	}

	@Override
	public List<User> paginationPage(int index, int numberOfPage) {
		return userDao.paginationPage(index, numberOfPage);
	}

	@Override
	public Long countAll() {
		return userDao.countAll();
	}

	@Override
	public User findOne(int userid) {
		return userDao.findOne(userid);
	}

}
