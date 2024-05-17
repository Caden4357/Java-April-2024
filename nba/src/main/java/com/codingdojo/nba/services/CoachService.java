package com.codingdojo.nba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.nba.models.Coach;
import com.codingdojo.nba.repositories.CoachRepository;

@Service
public class CoachService {
	@Autowired
	CoachRepository cRepo;

	public List<Coach> allCoachs() {
		return cRepo.findAll();
	}

	public Coach newCoach(Coach coach) {
		return cRepo.save(coach);

	}

	// retrieves an artist
	public Coach findCoach(Long id) {
		Optional<Coach> coach = cRepo.findById(id);
		if (coach.isPresent()) {
			return coach.get();
		} else {
			return null;
		}
	}

	public void deleteCoach(Long id) {
		cRepo.deleteById(id);
	}

	public Coach updateCoach(Coach coach) {
		return cRepo.save(coach);
	}
}

