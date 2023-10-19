package entity;


import java.io.Serializable;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
// tên của table in mysql
@Table(name = "category")
// tên của entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	private int CategoryID;
	
	@Column(name ="CategoryName")
	private String CategoryName;
	@Column(name = "icon")
	private String icon;
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products;

	public Category(int CategoryID, String CategoryName, String icon, List<Product> products ) {
		super();
		this.CategoryID = CategoryID;
		this.CategoryName = CategoryName;
		this.icon = icon;
		this.products = products;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	@Override
	public String toString() {
		return "Category [CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", icon=" + icon
				+ ", products=" + products + "]";
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
