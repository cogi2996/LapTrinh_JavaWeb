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
	public List<ProductModel> findProductByCateId(int id) {
		// TODO Auto-generated method stub
		return ProductDAO.findProductById(id);
	}
	@Override
	public void insert(ProductModel pro) {
		// TODO Auto-generated method stub
		ProductDAO.insert(pro);
		
	}
	@Override
	public void update(ProductModel pro) {
		// TODO Auto-generated method stub
		ProductDAO.update(pro);
		
	}
	@Override
	public ProductModel findOne(int id) {
		// TODO Auto-generated method stub
		ProductModel product = ProductDAO.findOne(id);
		return product;
	}

}
