package hcmute.Model;

public class AuthorBook_21110709 {
	private int author_id;
	private int numberBook;

	@Override
	public String toString() {
		return "AuthorBook [author_id=" + author_id + ", numberBook=" + numberBook + "]";
	}

	public AuthorBook_21110709(int author_id, int numberBook) {
		super();
		this.author_id = author_id;
		this.numberBook = numberBook;
	}

	public AuthorBook_21110709() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getNumberBook() {
		return numberBook;
	}

	public void setNumberBook(int numberBook) {
		this.numberBook = numberBook;
	}

}
