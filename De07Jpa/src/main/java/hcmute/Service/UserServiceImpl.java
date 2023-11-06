package hcmute.Service;

import java.util.List;

import hcmute.Dao.IUserDao;
import hcmute.Dao.UserDaoImpl;
import hcmute.Entity.User;
import hcmute.Model.Video;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		return userDao.findOne(username);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(String username) {
		userDao.delete(username);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public Long countAll() {
		return userDao.countAll();
	}

	@Override
	public List<User> paginationPage(int index, int numberOfPage) {
		return userDao.paginationPage(index, numberOfPage);
	}

	@Override
	public List<Video> listLikedVideo(String username) {
		return userDao.listLikedVideo(username);
	}

	@Override
	public List<User> findUser(String input) {
		// TODO Auto-generated method stub
		return userDao.findUser(input);
	}

}
