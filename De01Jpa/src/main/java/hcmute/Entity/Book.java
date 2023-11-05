package hcmute.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookid;
	private int isbn;
	private String title;
	private String publisher;
	private int price;
	private String description;
	private Date publish_date;
	private String cover_image;
	private int quantity;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "bookid"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", isbn=" + isbn + ", title=" + title + ", publisher=" + publisher
				+ ", price=" + price + ", description=" + description + ", publish_date=" + publish_date
				+ ", cover_image=" + cover_image + ", quantity=" + quantity + ", authors=" + authors + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, int isbn, String title, String publisher, int price, String description, Date publish_date,
			String cover_image, int quantity, List<Author> authors) {
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quantity = quantity;
		this.authors = authors;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
