package hcmute.models;

public class CategoryModel {
	private int CategoryID;
	private String CategoryName;
	private String icon;
	public CategoryModel() {
		super();
	}
	public CategoryModel(int CategoryID,String CategoryName,String icon) {
		super();
		this.setCategoryID(CategoryID);
		this.setCategoryName(CategoryName);
		this.setIcon(icon);
	}
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
