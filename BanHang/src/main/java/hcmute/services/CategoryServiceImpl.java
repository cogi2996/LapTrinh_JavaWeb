package hcmute.services;

import java.util.List;
import java.util.Locale.Category;

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
	public void edit(CategoryModel newCate) {
		// create old cate
		CategoryModel oldCate = this.findOne(newCate.getCateID());
		// update model old with new change
		System.out.println("new img"+ newCate.getImages());
		System.out.println("old img "+oldCate.getImages());
		if(!newCate.getCateName().equals(oldCate.getCateName()))
		{
			oldCate.setCateName(newCate.getCateName());
		}
		if(!newCate.getImages().equals(oldCate.getImages()) ) {
			oldCate.setImages(newCate.getImages());
			System.out.println("old cate update "+ oldCate.getImages());
		}
		// implemenmt update edit in database 
		System.out.println("UPDATED old cate:"+ oldCate);
		cateDao.editModel(oldCate);
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cateDao.delete(id);
	}
	
	
	
	
	
	
}
