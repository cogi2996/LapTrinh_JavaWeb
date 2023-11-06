package hcmute.Dao;

import java.util.List;

import hcmute.Model.User_21110709;

public interface IUserDao_21110709 {
	public void insert(User_21110709 user); 
	public void update(User_21110709 user); 
	public void delete(int userid); 
	public List<User_21110709> paginationPage(int index, int numberOfPage); 
	public Long countAll ();
	User_21110709 findOne(int userid);	
}
