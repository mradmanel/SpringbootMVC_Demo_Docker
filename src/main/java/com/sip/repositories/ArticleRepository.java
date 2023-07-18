package com.sip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.entities.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Long> {


	@Query("FROM Article a WHERE a.label LIKE label")
	List<Article> findByLabel(String label);



}
