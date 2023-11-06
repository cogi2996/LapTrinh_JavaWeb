package hcmute.Model;

import java.sql.Date;

public class Video {
	private int videoId;
	private Date likedDate;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Video(int videoId, Date likedDate) {
		super();
		this.videoId = videoId;
		this.likedDate = likedDate;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", likedDate=" + likedDate + "]";
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public Date getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}
	
}
