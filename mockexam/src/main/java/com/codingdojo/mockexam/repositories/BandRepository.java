package com.codingdojo.mockexam.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mockexam.models.Band;

@Repository
public interface BandRepository extends CrudRepository<Band, Long> {
	List<Band> findAll();
	List<Band> findAllByOrderByGenreAsc();

}
