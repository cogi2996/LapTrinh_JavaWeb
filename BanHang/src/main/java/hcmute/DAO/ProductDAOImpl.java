package hcmute.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.ProductModel;

public class ProductDAOImpl implements IProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product";
		// Xử lí bài toán
		try {

			// Kết nối database
//		conn = new DBConnection().getConnection();
			conn = new DBConnection().getConnection();
			// đưa câu truy vấn vào và thực thi
			ps = conn.prepareStatement(sql);
			// lấy kết quả ra resultset
			rs = ps.executeQuery();
			// Đọc resultset đưa vào model
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProID(rs.getInt("ProductID"));
				product.setProName(rs.getString("ProductName"));
				product.setProDes(rs.getString("Description"));
				product.setProPrice(rs.getInt("Price"));
				product.setProImg(rs.getString("imageLink"));
				product.setCateID(rs.getInt("CategoryID"));
				product.setSellerID(rs.getInt("SellerID"));
				product.setAmount(rs.getInt("Amount"));
				product.setStoke(rs.getInt("stoke"));
				list.add(product);
				//System.out.println(product);
			}
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("false");
		}
		return list;
	}
	public static void main(String[] args) {
		try {
			List<ProductModel> list = new ProductDAOImpl(). findAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	@Override
	public List<ProductModel> findProductById(int id) {
		// TODO Auto-generated method stub
		String sql = "select *\r\n"
				+ "from product\r\n"
				+ "where product.ProductID = ?";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pro = new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9)
						);
				System.out.println("pro:" +pro);
				list.add(pro);
			}
			conn.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
