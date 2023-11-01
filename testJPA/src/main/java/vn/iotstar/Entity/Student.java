package vn.iotstar.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    Long id;

    @ManyToMany
    @JoinTable(
      name = "course_like", 
      joinColumns = @JoinColumn(name = "student_id"), 
      inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> likedCourses;

}