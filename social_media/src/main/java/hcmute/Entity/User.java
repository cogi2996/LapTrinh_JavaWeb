package hcmute.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int userID;
	private String mobile;
	@Temporal(value = TemporalType.DATE)
	private Date createDate;
	@Temporal(value = TemporalType.DATE)
	private Date lastLogin;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String biography;
	private String position;
	private String workPlace;
	private String avatar;
	private String cover;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Group> group;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid") 
	private Account account;

	// 1-nhiều giữa user và userpost
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserPost> uPosts;


	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<GroupPost> groupPosts;

}
