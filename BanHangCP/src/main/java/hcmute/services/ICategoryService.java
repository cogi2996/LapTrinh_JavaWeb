package hcmute.services;

import java.util.List;

import hcmute.models.ProductModel;

public interface ICategoryService {
	List<ProductModel> findProductByCateory(int id);
}
