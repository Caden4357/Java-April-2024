package com.codingdojo.springsecurity.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.springsecurity.models.User;
import com.codingdojo.springsecurity.repositories.RoleRepository;
import com.codingdojo.springsecurity.repositories.UserRepository;

@Service
public class UserService {
   private UserRepository userRepository;
   private RoleRepository roleRepository;
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   
   public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
       this.userRepository = userRepository;
       this.roleRepository = roleRepository;
       this.bCryptPasswordEncoder = bCryptPasswordEncoder;
   }
   
   
   // 1
   public void saveWithUserRole(User user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       user.setRoles(roleRepository.findByName("ROLE_USER"));
       userRepository.save(user);
   }
    
    // 2 
   public void saveUserWithAdminRole(User user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
       userRepository.save(user);
   }    
   
   // 3
   public User findByUsername(String username) {
       return userRepository.findByUsername(username);
   }
}
