package com.codingdojo.musicZone.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.musicZone.models.Artist;
//                                                     TableName, id Data Type

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
	List<Artist> findAll(); // get all query we are overwriting the return type for our benefit
}
