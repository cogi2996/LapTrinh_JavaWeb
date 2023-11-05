package hcmute.Model;

public class BookRating {
	private int bookid;
	private String title;
	private int rating;

	@Override
	public String toString() {
		return "BookRating [bookid=" + bookid + ", title=" + title + ", rating=" + rating + "]";
	}

	public BookRating(int bookid, String title, int rating) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.rating = rating;
	}

	public BookRating() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
