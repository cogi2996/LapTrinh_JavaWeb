package hcmute.DAO;

import java.util.List;

import hcmute.models.ProductModel;

public interface IProductDAO {
	
	List<ProductModel> findAll();
}
