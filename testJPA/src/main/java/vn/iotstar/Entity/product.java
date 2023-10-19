package vn.iotstar.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
//tên của table in mysql
@Table(name = "product")
//tên của entity
@NamedQuery(name = "product.findAll", query = "SELECT c FROM product c")
public class product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private int ProductID;
	@Column(name="ProductName")
	private String ProductName;
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category category;
	public product(int productID, String productName, Category category) {
		super();
		ProductID = productID;
		ProductName = productName;
		this.category = category;
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "product [ProductID=" + ProductID + ", ProductName=" + ProductName + ", category=" + category + "]";
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
