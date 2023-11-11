package hcmute.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Group")
@NamedQuery(name = "Group.findAll", query = "SELECT c FROM Group c")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int groupID;
	private String groupName;
	@Temporal(value = TemporalType.DATE)
	private Date createTime;
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	// 1 - n với grouppost
	@OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
	private List<GroupPost> listPost;

}
