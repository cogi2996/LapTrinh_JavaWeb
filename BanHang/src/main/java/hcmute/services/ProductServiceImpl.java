package hcmute.services;

import java.util.List;

import hcmute.DAO.IProductDAO;
import hcmute.DAO.ProductDAOImpl;
import hcmute.models.ProductModel;

public class ProductServiceImpl implements IProductService {
	IProductDAO ProductDAO = new ProductDAOImpl();
	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return ProductDAO.findAll();
	}
	@Override
	public List<ProductModel> findProductById(int id) {
		// TODO Auto-generated method stub
		return ProductDAO.findProductById(id);
	}
	

}
