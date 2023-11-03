package hcmute.vn.Model;

public class User {
	public String Username;
	public String Password;
	public String Phone;
	public String Fullname;
	public String Email;
	public String Images;
	
	
	
	@Override
	public String toString() {
		return "User [Username=" + Username + ", Password=" + Password + ", Phone=" + Phone + ", Fullname=" + Fullname
				+ ", Email=" + Email + ", Images=" + Images + "]";
	}
	public User(String username, String password, String phone, String fullname, String email, String images) {
		super();
		Username = username;
		Password = password;
		Phone = phone;
		Fullname = fullname;
		Email = email;
		Images = images;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getImages() {
		return Images;
	}
	public void setImages(String images) {
		Images = images;
	}
	

}
