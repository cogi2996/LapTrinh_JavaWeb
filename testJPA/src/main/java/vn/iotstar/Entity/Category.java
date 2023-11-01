package vn.iotstar.Entity;

import java.io.Serializable;
import java.util.List;

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

	@Column(name = "CategoryName")
	private String CategoryName;
	@Column(name = "icon")
	private String icon;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<product> products;

	  
	public Category(int categoryID, String categoryName, String icon, List<product> products) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
		this.icon = icon;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<product> getProducts() {
		return products;
	}

	public void setProducts(List<product> products) {
		this.products = products;
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

	@Override
	public String toString() {
		return "Category [CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", icon=" + icon + "]";
	}

	
}
