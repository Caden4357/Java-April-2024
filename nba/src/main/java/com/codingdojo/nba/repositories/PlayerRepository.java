package com.codingdojo.nba.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nba.models.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findAll();
}