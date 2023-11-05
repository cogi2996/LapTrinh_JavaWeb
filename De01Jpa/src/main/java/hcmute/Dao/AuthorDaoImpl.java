package hcmute.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hcmute.Entity.Author;
import hcmute.JpaConfig.JPAConfig;

public class AuthorDaoImpl implements IAuthorDao{

	@Override
	public List<Author> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Author> query = enma.createNamedQuery("Author.findAll", Author.class);
		return query.getResultList();
	}

}
