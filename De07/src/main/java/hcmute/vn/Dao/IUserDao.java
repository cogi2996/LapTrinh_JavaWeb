package hcmute.vn.Dao;

import java.util.List;

import hcmute.vn.Model.User;


public interface IUserDao {
	List<User> paginationUser(int index, int numberOfPage);

	int countAll();
	void insert(User user);
}
