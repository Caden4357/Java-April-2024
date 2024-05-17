package com.codingdojo.nba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.nba.models.Player;
import com.codingdojo.nba.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	PlayerRepository pRepo;

	public List<Player> allPlayers() {
		return pRepo.findAll();
	}

	public Player create(Player player) {
		return pRepo.save(player);

	}

	// retrieves an artist
	public Player findPlayer(Long id) {
		Optional<Player> player = pRepo.findById(id);
		if (player.isPresent()) {
			return player.get();
		} else {
			return null;
		}
	}

	public void deletePlayer(Long id) {
		pRepo.deleteById(id);
	}

	public Player updatePlayer(Player player) {
		return pRepo.save(player);
	}
}

