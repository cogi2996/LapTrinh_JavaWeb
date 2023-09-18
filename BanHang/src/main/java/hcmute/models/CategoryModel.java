package hcmute.models;

import java.io.Serializable;

public class CategoryModel implements Serializable {

	private static final long serialVersionUID = 1L;
	// có bao nhiều trường trong catetory thì có bấy nhiêu biến
	// ngoài ra model có thể có các biến không có trong database ( ví dụ: biến fullnaem ( trung gian ) kết nối firstName & lastName
	private int cateID;
	private String images;
	private String cateName;
	// tạo constructor
	public CategoryModel() {
		super();
	}
	public CategoryModel(int cateID, String images, String cateName) {
		super();
		this.cateID = cateID;
		this.images = images;
		this.cateName = cateName;
	}
	
	// tạo getter và setter 

	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "CatetoryModel [cateID=" + cateID + ", images=" + images + ", cateName=" + cateName + "]";
	}
	
	
	
}
