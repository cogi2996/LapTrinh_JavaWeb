package hcmute.services;

import java.util.List;
import hcmute.models.CategoryModel;

public interface ICategoryService {
	// định nghĩa phương thức
	List<CategoryModel> findAll();
	void insert(CategoryModel model);
	void update(CategoryModel model);
	CategoryModel findOne(int id);
	void edit(CategoryModel model);
	void delete(int id);
}
