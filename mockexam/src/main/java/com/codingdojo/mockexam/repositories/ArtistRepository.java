package com.codingdojo.mockexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mockexam.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
	List<Artist> findAll();
	List<Artist> findAllByOrderByGenreAsc();
}