package com.codingdojo.mockexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mockexam.models.Musician;

@Repository
public interface MusicianRepository extends CrudRepository<Musician, Long> {
	List<Musician> findAll();
}
