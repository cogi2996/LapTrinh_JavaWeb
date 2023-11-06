package hcmute.Entity;

import java.io.Serializable;
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
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	private String phone;
	private String fullname;
	private String email;
	private boolean admin;
	private boolean active;
	private String images;
	@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
	private List<Video> videos;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", fullname=" + fullname
				+ ", email=" + email + ", admin=" + admin + ", active=" + active + ", images=" + images + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String phone, String fullname, String email, boolean admin,
			boolean active, String images) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
		this.active = active;
		this.images = images;
	}
	
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}
