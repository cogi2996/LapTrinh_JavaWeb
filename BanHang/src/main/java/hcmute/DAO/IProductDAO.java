package hcmute.DAO;

import java.util.List;

import hcmute.models.ProductModel;

public interface IProductDAO {
	
	List<ProductModel> findAll();
	List<ProductModel> findProductById(int id);
	void insert(ProductModel model);
	void update(ProductModel model);
	ProductModel findOne(int id);
}
