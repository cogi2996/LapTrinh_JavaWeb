package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.CategoryModel;

// lớp thực thi các interface CategoryDAO
public class CategoryDAOImpl implements iCategoryDAO{
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
				System.out.println(cate);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("false");
		}
		return list;
	}
	
}
