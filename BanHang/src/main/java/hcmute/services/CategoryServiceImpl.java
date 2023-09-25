package hcmute.services;

import java.util.List;

import hcmute.DAO.CategoryDAOImpl;
import hcmute.DAO.iCategoryDAO;
import hcmute.models.CategoryModel;

// triển khai tất cả các phương thức trên interface Icategoryservice
public class CategoryServiceImpl implements ICategoryService{
	// khởi tạo đối tượng trong DAO
	iCategoryDAO cateDao = new CategoryDAOImpl();
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		
		return cateDao.findAll();
	}
	@Override
	public void insert(CategoryModel model) {
		// TODO Auto-generated method stub
		cateDao.insert(model);
	}
	@Override
	public void update(CategoryModel model) {
		// TODO Auto-generated method stub
		// xử lí logic : kiểm tra dữ liệu có thực sự bị thay đỗi không
		// nếu có thì cập nhật
		// không có thì lấy dữ liệu cũ
		cateDao.update(model);
		
	}
	@Override
	public CategoryModel findOne(int id) {
		// TODO Auto-generated method stub
		return cateDao.findOne(id);
	}
	@Override
	public void edit(int id, String NewCateName, String NewImages) {
		// TODO Auto-generated method stub
		cateDao.editModel(id, NewCateName, NewImages);
	}
	
	
	
	
}
