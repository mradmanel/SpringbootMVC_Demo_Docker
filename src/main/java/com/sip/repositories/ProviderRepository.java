package com.sip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.entities.Article;
import com.sip.entities.Provider;

@Repository
public interface ProviderRepository extends CrudRepository <Provider,Long>{



	@Query("FROM Provider p WHERE p.name LIKE name")
	List<Provider> findbyName(String name );



	




}
