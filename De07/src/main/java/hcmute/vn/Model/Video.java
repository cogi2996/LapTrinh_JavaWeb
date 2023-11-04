package hcmute.vn.Model;

public class Video {
	private int videoID;
	private String title;
	private String poster;
	private int views;
	private String description;
	private boolean active;
	private int categoryID;

	@Override
	public String toString() {
		return "Video [videoID=" + videoID + ", title=" + title + ", poster=" + poster + ", views=" + views
				+ ", description=" + description + ", active=" + active + ", categoryID=" + categoryID + "]";
	}

	public Video(int videoID, String title, String poster, int views, String description, boolean active,
			int categoryID) {
		super();
		this.videoID = videoID;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.active = active;
		this.categoryID = categoryID;
	}

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVideoID() {
		return videoID;
	}

	public void setVideoID(int videoID) {
		this.videoID = videoID;
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

}
