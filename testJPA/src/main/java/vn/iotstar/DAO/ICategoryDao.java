package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.Entity.Category;

public interface ICategoryDao {
	List<Category> findAll();
	void insert(Category cate);
}
