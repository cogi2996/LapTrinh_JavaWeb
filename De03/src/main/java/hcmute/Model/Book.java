package hcmute.Model;

public class Book {
	private int bookid;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid) {
		super();
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + "]";
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	
}
