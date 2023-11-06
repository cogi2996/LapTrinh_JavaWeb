package hcmute.Model;

import java.sql.Date;

public class Book_21110709 {
	private int bookid;
	private String title;
	private int isbn;
	private String author;
	private String publisher;
	private Date publish_date;
	private int quantity;
	private int review;
	private String cover_image;

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", isbn=" + isbn + ", author=" + author + ", publisher="
				+ publisher + ", publish_date=" + publish_date + ", quantity=" + quantity + ", review=" + review
				+ ", cover_image=" + cover_image + "]";
	}

	public Book_21110709() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book_21110709(int bookid, String title, int isbn, String author, String publisher, Date publish_date, int quantity,
			int review, String cover_image) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.quantity = quantity;
		this.review = review;
		this.cover_image = cover_image;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}

}