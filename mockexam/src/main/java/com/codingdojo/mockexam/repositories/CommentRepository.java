package com.codingdojo.mockexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mockexam.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	List<Comment> findAll();
}
