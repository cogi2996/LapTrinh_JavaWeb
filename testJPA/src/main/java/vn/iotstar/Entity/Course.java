package vn.iotstar.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	Long id;

	@ManyToMany(mappedBy = "likedCourses")
	List<Student> likes;

}
