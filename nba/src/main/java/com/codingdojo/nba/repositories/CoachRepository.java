package com.codingdojo.nba.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nba.models.Coach;

@Repository
public interface CoachRepository extends CrudRepository<Coach, Long> {
	List<Coach> findAll();
}