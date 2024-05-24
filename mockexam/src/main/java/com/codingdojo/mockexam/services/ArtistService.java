package com.codingdojo.mockexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mockexam.models.Artist;
import com.codingdojo.mockexam.repositories.ArtistRepository;

@Service
public class ArtistService {
	@Autowired
	ArtistRepository aRepo;

	public List<Artist> allArtists() {
		return aRepo.findAll();
	}

	public List<Artist> allArtistByGenreAsc() {
		return aRepo.findAllByOrderByGenreAsc();
	}
	public Artist newArtist(Artist artist) {
		return aRepo.save(artist);

	}

	// retrieves an artist
	public Artist findArtist(Long id) {
		Optional<Artist> artist = aRepo.findById(id);
		if (artist.isPresent()) {
			return artist.get();
		} else {
			return null;
		}
	}

	public void deleteArtist(Long id) {
		aRepo.deleteById(id);
	}

	public Artist updateArtist(Artist artist) {
		return aRepo.save(artist);
	}
}

