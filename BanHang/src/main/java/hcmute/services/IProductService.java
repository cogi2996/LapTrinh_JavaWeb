package hcmute.services;

import java.util.List;

import hcmute.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
}
