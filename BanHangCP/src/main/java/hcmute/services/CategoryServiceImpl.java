package hcmute.services;

import java.util.ArrayList;
import java.util.List;

import hcmute.DAO.IProductDAO;
import hcmute.DAO.ProductDAOImpl;
import hcmute.models.ProductModel;

public class CategoryServiceImpl implements ICategoryService {
	IProductDAO productDAO = new ProductDAOImpl();
	@Override
	public List<ProductModel> findProductByCateory(int id) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		// TODO Auto-generated method stub
		for(ProductModel product : productDAO.findAll()) {
			if(product.getCateID() == id) {
				list.add(product);
			}
		}
		return list;
	}
	public static void main(String[] arg) {
		CategoryServiceImpl cateService = new CategoryServiceImpl();
		
		for(ProductModel product : cateService.findProductByCateory(2)) {
			System.out.println(product);
		}
	}

}
