package services;

import java.util.List;

import entity.Category;

public interface ICategoryService {
	void insert (Category category);
	List<Category> findAll();
}
