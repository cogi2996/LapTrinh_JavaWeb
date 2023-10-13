package hcmute.models;

import java.io.Serializable;

public class ProductModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int proID;
	private String proName;
	private String proDes;
	private int proPrice;
	private String proImg;
	private int cateID;
	private int sellerID;
	private int amount;
	private int stoke;

	public ProductModel() {
		super();
	}

	public ProductModel(int proID, String proName, String proDes, int proPrice, String proImg, int cateID, int sellerID,
			int amount, int stoke) {
		this.proID = proID;
		this.proName = proName;
		this.proDes = proDes;
		this.proPrice = proPrice;
		this.proImg = proImg;
		this.cateID = cateID;
		this.sellerID = sellerID;
		this.amount = amount;
		this.stoke = stoke;
	}

	
	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDes() {
		return proDes;
	}

	public void setProDes(String proDes) {
		this.proDes = proDes;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public String getProImg() {
		return proImg;
	}

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	@Override
	public String toString() {
		return "ProductModel [proID=" + proID + ", proName=" + proName + ", proDes=" + proDes + ", proPrice=" + proPrice
				+ ", proImg=" + proImg + ", cateID=" + cateID + ", sellerID=" + sellerID + ", amount=" + amount
				+ ", stoke=" + stoke + "]";
	}



}
