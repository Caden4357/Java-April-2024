package com.codingdojo.loginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	public User register(User newUser, BindingResult result) {
		
//		see if the email already exists in the DB
		Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());
			// if it does throw an error 
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "matches", "An account already exists please sign in.");
		}
//		if the password matches the confirm password 
		// if it doesnt throw an error 
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Confirm password and password must match");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
// 		if we get this far we need to hash and salt the password and save the user in the DB
		
		String hashedPass = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPass);
		return uRepo.save(newUser);
	}
}
