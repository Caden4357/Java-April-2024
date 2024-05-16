package com.codingdojo.nba.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nba.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	List<Team> findAll(); 

}
