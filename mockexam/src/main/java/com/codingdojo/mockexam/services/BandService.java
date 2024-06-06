package com.codingdojo.mockexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mockexam.models.Band;
import com.codingdojo.mockexam.models.Musician;
import com.codingdojo.mockexam.repositories.BandRepository;


@Service
public class BandService {

	@Autowired
	BandRepository bRepo;

	// get all
	public List<Band> allBands() {
		return bRepo.findAll();
	}

	public List<Band> getAllBandsOrderedByGenre() {
		return bRepo.findAllByOrderByGenreAsc();
	}

	// create new
	public Band createBand(Band band) {
		return bRepo.save(band);
	}

	// Get one
	public Band oneBand(Long id) {
		Optional<Band> band = bRepo.findById(id);
		if (band.isPresent()) {
			return band.get();
		} else {
			return null;
		}
	}

	// delete one
	public void deleteBand(Long id) {
		bRepo.deleteById(id);
	}

	// update one
	public Band updateBand(Band band) {
		return bRepo.save(band);
	}

	public void addMusicianToBand(Musician musician, Band band) {
		if(band.getMusicians().contains(musician)) {
			return;
		}
		else {
			band.getMusicians().add(musician);
			bRepo.save(band);
		}
	}
}
