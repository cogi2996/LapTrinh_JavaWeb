package hcmute.Dao;

import java.util.List;

import hcmute.Entity.User;

public interface IUserDao {
	public void insert(User user); 
	public void update(User user); 
	public void delete(int userid); 
	public List<User> paginationPage(int index, int numberOfPage); 
	public Long countAll ();
	User findOne(int userid);	
}
