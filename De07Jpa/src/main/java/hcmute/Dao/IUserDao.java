package hcmute.Dao;

import java.util.List;

import hcmute.Controllers.admin.listUser;
import hcmute.Entity.User;
import hcmute.Model.Video;

public interface IUserDao {
	List<User> findAll(); // Find all users

	User findOne(String username); // Find a single user by username

	void update(User user); // Update an existing user's information

	void delete(String username); // Delete a user by username

	void insert(User user);

	Long countAll(); // Count all users in the database

	List<User> paginationPage(int index, int numberOfPage);
	List<Video> listLikedVideo(String username);
	List<User> findUser(String input);
}
