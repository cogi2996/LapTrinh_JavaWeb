package hcmute.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "author")
@NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int author_id;
	private String author_name;
	private Date date_of_birth;

	@ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
	private List<Book> books;

	

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_name=" + author_name + ", date_of_birth=" + date_of_birth
				+ "]";
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int author_id, String author_name, Date date_of_birth, List<Book> books) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.date_of_birth = date_of_birth;
		this.books = books;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
