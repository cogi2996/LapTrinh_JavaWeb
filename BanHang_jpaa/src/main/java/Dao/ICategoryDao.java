package Dao;

import java.util.List;

import entity.Category;

public interface ICategoryDao {
	void insert (Category category);
	void update (Category category);
	void delete(int cateid) throws Exception;
	Category findById(int cateid);
	List<Category> findByCategoryname(String catename);
	List<Category> findAll();
	int count();
	
}
