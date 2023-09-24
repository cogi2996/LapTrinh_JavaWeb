package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.CategoryModel;

public class CategoryDAOImpl implements iCategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<CategoryModel> findAll() {
		{
			List<CategoryModel> list = new ArrayList<CategoryModel>();
			try {
				// ép từ arrayList sang list( một iterator arraylist-> list)
				String sql = "select * from category";
				// connect data
				conn = new DBConnection().getConnection();
				// fetch data from category resultset
				// đưa vào câu truy vấn của conn
				ps = conn.prepareStatement(sql);
				// thực thi
				rs = ps.executeQuery();
				// import data resultset into list
				while (rs.next()) {
					// create new model from rs
					CategoryModel cate = new CategoryModel();
					cate.setCateID(rs.getInt("CategoryID"));
					cate.setCateName(rs.getString("CategoryName"));
					cate.setImages(rs.getString("icon"));
					list.add(cate);
					System.out.println(cate);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("false using findall");
			}
			return list;
		}

	}
}
