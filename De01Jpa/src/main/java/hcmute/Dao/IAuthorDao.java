package hcmute.Dao;

import java.util.List;

import hcmute.Entity.Author;


public interface IAuthorDao {
	List<Author> findAll();
}
