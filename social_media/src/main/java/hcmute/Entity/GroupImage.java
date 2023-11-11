package hcmute.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "GroupImage")
@NamedQuery(name = "GroupImage.findAll", query = "select gi from GroupImage gi")
public class GroupImage {
	@Id
	private int groupImageID;
	private int groupPostID;
	private String groupImageFile;
	// 1 nhiều với GroupPost
	@ManyToOne
	@JoinColumn(name = "groupPostID") 
	private GroupPost grPost;
}
