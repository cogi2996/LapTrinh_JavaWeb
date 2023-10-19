package services;

import java.util.List;

import Dao.CategoryDaoImpl;
import Dao.ICategoryDao;
import entity.Category;

public class CategoryServiceImpl implements ICategoryService{
	ICategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public void insert(Category category) {
		categoryDao.insert(category);
	}
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
}
