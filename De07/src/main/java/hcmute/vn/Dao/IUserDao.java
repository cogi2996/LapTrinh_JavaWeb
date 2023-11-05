package hcmute.vn.Dao;

import java.io.IOException;
import java.util.List;

import hcmute.vn.Model.Favorites;
import hcmute.vn.Model.User;

public interface IUserDao {
	List<User> paginationUser(int index, int numberOfPage);

	int countAll();
	void insert(User user);
	void detete(String username);
	void update(User user);
	 User findOne(String username);
	 List<Favorites> findFavorByUsername(String username);
	 List<User> findUserByNameOrEmail(String input);
	 
}
