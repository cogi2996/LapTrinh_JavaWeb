package hcmute.vn.Model;

import java.sql.Date;

public class Favorites {
	private int favoriteID;
	private Date likedDate;
	private int videoId;
	private String username;
	
	@Override
	public String toString() {
		return "Favorites [favoriteID=" + favoriteID + ", likedDate=" + likedDate + ", videoId=" + videoId
				+ ", username=" + username + "]";
	}

	public Favorites() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFavoriteID() {
		return favoriteID;
	}

	public void setFavoriteID(int favoriteID) {
		this.favoriteID = favoriteID;
	}

	public Date getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
