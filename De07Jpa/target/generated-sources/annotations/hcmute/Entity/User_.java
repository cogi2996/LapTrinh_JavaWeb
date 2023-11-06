package hcmute.Entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> images;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, Boolean> admin;
	public static volatile SingularAttribute<User, Boolean> active;
	public static volatile ListAttribute<User, Video> videos;
	public static volatile SingularAttribute<User, String> fullname;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String IMAGES = "images";
	public static final String PHONE = "phone";
	public static final String ADMIN = "admin";
	public static final String ACTIVE = "active";
	public static final String VIDEOS = "videos";
	public static final String FULLNAME = "fullname";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

}

