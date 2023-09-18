package hcmute.DAO;

import java.util.List;

import hcmute.models.CategoryModel;

public interface iCategoryDAO {
	List<CategoryModel> findAll ();
	// khai báo thủ tục thì dùng void
	//isert , updated, delete
}
