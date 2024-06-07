package com.codingdojo.flashfeed.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.flashfeed.models.Comment;
import com.codingdojo.flashfeed.repositories.CommentRepository;


@Service
public class CommentService {

	@Autowired
	CommentRepository cRepo;

	//	get all
	public List<Comment> allComment() {
		return cRepo.findAll();
	}

	//	create new 
	public Comment createComment(Comment comment) {
		System.out.println(comment.getId());
		return cRepo.save(comment);
	}

	//	Get one 
	public Comment oneComment(Long id) {
		Optional<Comment> comment = cRepo.findById(id);
		if (comment.isPresent()) {
			return comment.get();
		} else {
			return null;
		}
	}

	// delete one
	public void deleteComment(Long id) {
		cRepo.deleteById(id);
	}

	// update one
	public Comment updateComment(Comment comment) {
		return cRepo.save(comment);
	}

}
