package hcmute.Entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Video.class)
public abstract class Video_ {

	public static volatile SingularAttribute<Video, String> description;
	public static volatile SingularAttribute<Video, Boolean> active;
	public static volatile SingularAttribute<Video, String> videoId;
	public static volatile SingularAttribute<Video, String> title;
	public static volatile SingularAttribute<Video, String> poster;
	public static volatile SingularAttribute<Video, Integer> views;
	public static volatile ListAttribute<Video, User> users;

	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String VIDEO_ID = "videoId";
	public static final String TITLE = "title";
	public static final String POSTER = "poster";
	public static final String VIEWS = "views";
	public static final String USERS = "users";

}

