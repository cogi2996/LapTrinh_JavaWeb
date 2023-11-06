package hcmute.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Videos")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VideoId", nullable = false, length = 50)
	private String videoId;

	@Column(name = "Title", length = 200)
	private String title;

	@Column(name = "Poster", length = 50)
	private String poster;

	@Column(name = "Views")
	private Integer views;

	@Column(name = "Description", length = 500)
	private String description;

	@Column(name = "Active")
	private Boolean active;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Favorites", joinColumns = @JoinColumn(name = "videoId"), inverseJoinColumns = @JoinColumn(name = "Username"))
	private List<User> users;
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
