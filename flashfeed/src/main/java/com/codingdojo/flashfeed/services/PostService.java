package com.codingdojo.flashfeed.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.flashfeed.models.Post;
import com.codingdojo.flashfeed.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository pRepo;

	//	get all
	public List<Post> allPost() {
		return pRepo.findAll();
	}

	//	create new 
	public Post createPost(Post post) {
		return pRepo.save(post);
	}

	//	Get one 
	public Post onePost(Long id) {
		Optional<Post> post = pRepo.findById(id);
		if (post.isPresent()) {
			return post.get();
		} else {
			return null;
		}
	}

	// delete one
	public void deletePost(Long id) {
		pRepo.deleteById(id);
	}

	// update one
	public Post updatePost(Post post) {
		return pRepo.save(post);
	}
}
