package com.codingdojo.flashfeed.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.flashfeed.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	List<Post> findAll();
}
