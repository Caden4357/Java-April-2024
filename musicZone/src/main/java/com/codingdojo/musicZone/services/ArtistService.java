package com.codingdojo.musicZone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.musicZone.models.Artist;
import com.codingdojo.musicZone.repositories.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	ArtistRepository aRepo;
	
//	get all artists 
	public List<Artist> allArtists(){
		return aRepo.findAll();
	}
//	create new artist
	public Artist newArtist(Artist artist) {
		return aRepo.save(artist);
	}
	
//	Get one artist
	public Artist oneArtist(Long id) {
		Optional<Artist> artist = aRepo.findById(id);
        if(artist.isPresent()) {
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
