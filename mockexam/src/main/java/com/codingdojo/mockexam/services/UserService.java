package com.codingdojo.mockexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mockexam.models.LoginUser;
import com.codingdojo.mockexam.models.User;
import com.codingdojo.mockexam.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository uRepo;

	public User register(User newUser, BindingResult result) {

//		find the user by email
		Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "matches", "An account already exists please sign in.");
		}
// 		if password and confirm dont match
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return uRepo.save(newUser);
	}

	public User login(LoginUser newLoginUser, BindingResult result) {
		Optional<User> potentialUser = uRepo.findByEmail(newLoginUser.getEmail());

		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found!");
			return null;
		}

		User user = potentialUser.get();

		if (!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}

		if (result.hasErrors()) {
			return null;
		}

		return user;
	}
	  public User findById(Long id) {
	    	Optional<User> potentialUser = uRepo.findById(id);
	    	if(potentialUser.isPresent()) {
	    		return potentialUser.get();
	    	}
	    	return null;
	    }
}
