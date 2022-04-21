package com.tts.Market.Service;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.Market.Model.Product;
import com.tts.Market.Model.User;
import com.tts.Market.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void saveNew(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	public void saveExisting(User user) {
		userRepository.save(user);
	}
	public User getLoggedInUser() {
		return findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	}
	public void updateCart(Map<Product, Integer> cart) {
		User user = getLoggedInUser();
		saveExisting(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		User user = findByUsername(username);
		if(user == null)throw new UsernameNotFoundException("Username not found.");
		return user;
	}
	
	
	
	
	
	
	
	

}
