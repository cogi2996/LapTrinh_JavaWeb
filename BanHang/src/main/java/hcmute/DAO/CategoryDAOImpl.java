package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaPrintableArea;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import hcmute.models.CategoryModel;

// lớp thực thi các interface CategoryDAO
public class CategoryDAOImpl implements iCategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "select * from category";
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
				CategoryModel cate = new CategoryModel();
				cate.setCateID(rs.getInt("CategoryID"));
				cate.setCateName(rs.getString("CategoryName"));
				cate.setImages(rs.getString("icon"));
				list.add(cate);

//				System.out.println(cate);
			}
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("false");
		}
		return list;
	}

	@Override
	public void insert(CategoryModel model) {
		// TODO xử lí dữ liệu cho insert
		String sql = "INSERT INTO Category (CategoryID, CategoryName, icon) VALUE\r\n" + "(?, ?, ?)";
		// tốt nhất CategoryID nên được thiết lập tự động tăng dần trong mysql
		try {
			conn = new DBConnection().getConnection(); // kết nối csdl
			ps = conn.prepareStatement(sql); // phát biểu câu query
			// truyền tham số vào query
			ps.setInt(1, model.getCateID());
			ps.setString(2, model.getCateName());
			ps.setString(3, model.getImages());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // in ra mã đỏ bị sai
		}

	}

	@Override
	public void update(CategoryModel model) {
		// TODO Auto-generated method stub
		// xử lí dữ liệu update
		String sql = "update INTO Category (CategoryID, CategoryName, icon) VALUE\r\n" + "(?, ?, ?)";
		// field nào mới thì mới = không thì không cần thay đõi

	}

	@Override
	public CategoryModel findOne(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from category where CategoryID = ?";
		CategoryModel model = new CategoryModel();
		try {
			conn = new DBConnection().getConnection(); // kết nối csdl
			ps = conn.prepareStatement(sql); // phát biểu câu query
			// truyền tham số vào query
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.setCateID(rs.getInt(1));
				model.setCateName(rs.getString(2));
				model.setImages(rs.getString(3));
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // in ra mã đỏ bị sai
		}
		return model;
	}

	@Override
	public void editModel(CategoryModel category) {
		String sql = "UPDATE Category \r\n" + "SET CategoryName = ?,icon =?" + "WHERE CategoryID = ?;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCateName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getCateID());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from Category" + " where CategoryID  = ?;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("DELETE DAO ACESS SUCCESS");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	// update

}
