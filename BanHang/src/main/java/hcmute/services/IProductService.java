package hcmute.services;

import java.util.List;

import hcmute.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	List<ProductModel> findProductByCateId(int cateID);
	void insert(ProductModel pro);
	void update(ProductModel pro);
	ProductModel findOne(int id);
}
