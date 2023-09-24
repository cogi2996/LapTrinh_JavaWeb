package hcmute.models;

public class CategoryModel {
	// ánh xạ attributes in database
	private int cateID;
	private String images;
	private String cateName;
	
	// tạo constructor
	public CategoryModel() {
		
	}
	public CategoryModel(int cateID, String images, String cateName) {
		this.cateID = cateID;
		this.images =  images;
		this.cateName = cateName;
	}
	
	// tạo getter và setter
	public int getCateID() {
		return cateID;
	}
	public String getImages() {
		return images;
	}
	public String getCateName() {
		return cateName;
	}
	
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "CatetoryModel [cateID=" + cateID + ", images=" + images + ", cateName=" + cateName + "]";
	}
}
