package hcmute.Entity;

import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Integer> quantity;
	public static volatile SingularAttribute<Book, Integer> price;
	public static volatile SingularAttribute<Book, Integer> isbn;
	public static volatile SingularAttribute<Book, String> publisher;
	public static volatile SingularAttribute<Book, String> description;
	public static volatile SingularAttribute<Book, String> cover_image;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Date> publish_date;
	public static volatile SingularAttribute<Book, Integer> bookid;
	public static volatile ListAttribute<Book, Author> authors;

	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";
	public static final String ISBN = "isbn";
	public static final String PUBLISHER = "publisher";
	public static final String DESCRIPTION = "description";
	public static final String COVER_IMAGE = "cover_image";
	public static final String TITLE = "title";
	public static final String PUBLISH_DATE = "publish_date";
	public static final String BOOKID = "bookid";
	public static final String AUTHORS = "authors";

}

