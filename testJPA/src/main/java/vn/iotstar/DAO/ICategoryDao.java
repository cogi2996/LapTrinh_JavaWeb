package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.Entity.Category;

public interface ICategoryDao {
	List<Category> findAll();
	List<Category> findAll(int page, int pagesize);
	void insert(Category cate);
	void update (Category cate);
	void delete(int id) throws Exception;
	public Category findById(int categoryId);
	
}
