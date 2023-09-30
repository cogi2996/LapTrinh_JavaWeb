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
	public CategoryModel findOne(int id) {
		// TODO Auto-generated method stub
		return cateDao.findOne(id);
	}
	@Override
	public void update(CategoryModel newCate) {
		// create old cate
		CategoryModel oldCate = this.findOne(newCate.getCateID());
		// update model old with new change
		
		if(!newCate.getCateName().equals(oldCate.getCateName()))
		{
			oldCate.setCateName(newCate.getCateName());
		}
		if(!newCate.getImages().equals(oldCate.getImages()) ) {
			oldCate.setImages(newCate.getImages());
		
		}
		// implemenmt update edit in database 
		System.out.println("UPDATED old cate:"+ oldCate);
		cateDao.update(oldCate);
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cateDao.delete(id);
	}
	
	
	
	
	
	
}
