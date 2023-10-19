package entity;

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

@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ProductID;
	private int stoke;
	private int Amount;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String Description;
	@Column(columnDefinition = "nvarchar(255)")
	private String ProductName;
	private String imageLink;
	private int SellerID;
	private int Price;
	@ManyToOne
	@JoinColumn(name = "CategoryID")
	private Category category;

	public Product(int productID, int stoke, int amount, String description, String productName, String imageLink,
			int sellerID, int price, Category category) {
		super();
		ProductID = productID;
		this.stoke = stoke;
		Amount = amount;
		Description = description;
		ProductName = productName;
		this.imageLink = imageLink;
		SellerID = sellerID;
		Price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", stoke=" + stoke + ", Amount=" + Amount + ", Description="
				+ Description + ", ProductName=" + ProductName + ", imageLink=" + imageLink + ", SellerID=" + SellerID
				+ ", Price=" + Price + ", category=" + category + "]";
	}

	public Product() {
		super();
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getSellerID() {
		return SellerID;
	}

	public void setSellerID(int sellerID) {
		SellerID = sellerID;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
