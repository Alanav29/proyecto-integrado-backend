package org.generation.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.generation.app.entity.Privilege;
import org.generation.app.entity.User;
import org.generation.app.repository.PrivilegeRepository;
import org.generation.app.repository.UserRepository;
import org.generation.app.service.PrivilegeService;
import org.generation.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PrivilegeRepository privilegeRepository;
	@Autowired
	PrivilegeService privilegeService;
	

	@Override
	public User getUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if( userOptional.isPresent()) return userOptional.get();
		else throw new IllegalStateException("User does not exist with id " + id);
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> existingUser = userRepository.findByEmail(email);
		if( existingUser.isPresent()) return existingUser.get();
		else throw new IllegalStateException("User does not exist with email " + email);
	}

	@Override
	public User createUser(User user) {
		Optional<Privilege> existingPrivilege = privilegeRepository.findByPrivilege("user");
		if( existingPrivilege.isPresent()) user.setPrivilege(existingPrivilege.get());
		else {
			Privilege userPrivilege = privilegeService.createPrivilege(new Privilege("user"));
			user.setPrivilege(userPrivilege);
			}
		user.setId(null);
		
		// TODO Verificar que no exista el email.
		User newUser = userRepository.save( user );
		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	@Override
	public User updateUser(User user, Long id) {
		User existingUser = getUserById(id);
		if(user.getFirstName() != "" && user.getFirstName() != null)existingUser.setFirstName( user.getFirstName());
		if(user.getLastName() != "" && user.getLastName() != null)existingUser.setLastName( user.getLastName());
		if(user.getPassword() != "" && user.getPassword() != null)existingUser.setPassword(user.getPassword());
		if(user.getPhone() != "" && user.getPhone() != null)existingUser.setPhone(user.getPhone());
		Optional<Privilege> existingPrivilege = privilegeRepository.findByPrivilege(user.getPrivilege().getPrivilege());
		if( existingPrivilege.isPresent()) existingUser.setPrivilege(existingPrivilege.get());
		
		// Si modificamos el email, se debe verificar que no exista.
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = getUserById(id);
		// userRepository.delete(existingUser);
		existingUser.setPrivilege(new Privilege((long) 3, "inactive"));
		userRepository.save(existingUser);
	}

	@Override
	public User validateUser(User user) {
		User existingUser = getUserByEmail(user.getEmail());
		
		if(existingUser.getPassword().equals( user.getPassword() ) ) return existingUser;
		else throw new IllegalStateException("Invalid credentials");
		
	}

}
