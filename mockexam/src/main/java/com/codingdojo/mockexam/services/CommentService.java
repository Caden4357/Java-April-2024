package com.codingdojo.mockexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mockexam.models.Comment;
import com.codingdojo.mockexam.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository cRepo;

	public List<Comment> allComments() {
		return cRepo.findAll();
	}

	public Comment newComment(Comment comment) {
		return cRepo.save(comment);

	}

	// retrieves an artist
	public Comment findComment(Long id) {
		Optional<Comment> comment = cRepo.findById(id);
		if (comment.isPresent()) {
			return comment.get();
		} else {
			return null;
		}
	}

	public void deleteComment(Long id) {
		cRepo.deleteById(id);
	}

	public Comment updateComment(Comment comment) {
		return cRepo.save(comment);
	}
}
