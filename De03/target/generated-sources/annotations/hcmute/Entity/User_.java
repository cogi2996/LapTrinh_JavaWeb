package hcmute.Entity;

import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Boolean> is_admin;
	public static volatile SingularAttribute<User, Date> signup_date;
	public static volatile SingularAttribute<User, Integer> phone;
	public static volatile SingularAttribute<User, String> passwd;
	public static volatile SingularAttribute<User, Date> last_login;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> fullname;
	public static volatile SingularAttribute<User, String> email;

	public static final String IS_ADMIN = "is_admin";
	public static final String SIGNUP_DATE = "signup_date";
	public static final String PHONE = "phone";
	public static final String PASSWD = "passwd";
	public static final String LAST_LOGIN = "last_login";
	public static final String ID = "id";
	public static final String FULLNAME = "fullname";
	public static final String EMAIL = "email";

}

