package com.codingdojo.mockexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mockexam.models.Musician;
import com.codingdojo.mockexam.repositories.MusicianRepository;

@Service
public class MusicianService {
	@Autowired
	MusicianRepository mRepo;

	public List<Musician> allMusicians() {
		return mRepo.findAll();
	}

	public Musician newMusician(Musician musician) {
		return mRepo.save(musician);

	}

	// retrieves an artist
	public Musician findMusician(Long id) {
		Optional<Musician> musician = mRepo.findById(id);
		if (musician.isPresent()) {
			return musician.get();
		} else {
			return null;
		}
	}

	public void deleteMusician(Long id) {
		mRepo.deleteById(id);
	}

	public Musician updateMusician(Musician musician) {
		return mRepo.save(musician);
	}
}
