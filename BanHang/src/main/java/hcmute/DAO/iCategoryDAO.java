package hcmute.DAO;

import java.util.List;

import hcmute.models.CategoryModel;

public interface iCategoryDAO {
	List<CategoryModel> findAll ();
	// khai báo thủ tục thì dùng void
	//isert , updated, delete
	void insert(CategoryModel model);
	CategoryModel findOne(int id);
	void update(CategoryModel model);
	void delete(int id);
}
