package hcmute.vn.Service;

import java.util.List;

import hcmute.vn.Dao.IUserDao;
import hcmute.vn.Dao.UserDaoImpl;
import hcmute.vn.Model.Favorites;
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
	@Override
	public void detete(String username) {
		userDao.detete(username);
	}
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		
	}
	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		return userDao.findOne(username);
	}
	@Override
	public List<Favorites> findFavorByUsername(String username) {
		return userDao.findFavorByUsername(username);
	}
	@Override
	public List<User> findUserByNameOrEmail(String input) {
		// TODO Auto-generated method stub
		return userDao.findUserByNameOrEmail(input);
	}
	
	
}
