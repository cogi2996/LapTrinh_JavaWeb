package hcmute.Entity;

import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ {

	public static volatile SingularAttribute<Author, String> author_name;
	public static volatile ListAttribute<Author, Book> books;
	public static volatile SingularAttribute<Author, Date> date_of_birth;
	public static volatile SingularAttribute<Author, Integer> author_id;

	public static final String AUTHOR_NAME = "author_name";
	public static final String BOOKS = "books";
	public static final String DATE_OF_BIRTH = "date_of_birth";
	public static final String AUTHOR_ID = "author_id";

}

