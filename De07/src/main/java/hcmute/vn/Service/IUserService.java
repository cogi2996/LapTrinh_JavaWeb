package hcmute.vn.Service;

import java.util.List;

import hcmute.vn.Model.User;



public interface IUserService {
	List<User> paginationUser(int index, int numberOfPage);
	int countAll();
	void insert(User user);
}
