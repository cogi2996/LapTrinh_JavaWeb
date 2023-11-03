package hcmute.vn.Model;

import java.sql.Date;

public class Author {
	private int author_id;
    private String author_name;
    private Date date_of_birth;
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_name=" + author_name + ", date_of_birth=" + date_of_birth
				+ "]";
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int author_id, String author_name, Date date_of_birth) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.date_of_birth = date_of_birth;
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
	
    
}