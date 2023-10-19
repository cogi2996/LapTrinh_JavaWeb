package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.Entity.product;

public interface IProductDao {
	List<product> findAll();

	void insert(product pro);
}
