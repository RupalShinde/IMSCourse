package com.example.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.dto.UserDTO;
import com.example.course.model.User;
import com.example.course.service.UserService;

@RestController
@RequestMapping("/users")
public class UserContoller {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDTO> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserDTO getUsersById(@PathVariable long id) {
		return userService.getUsersById(id);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
		User savedUser = userService.createOrUpdateUser(user);
		return ResponseEntity.ok(savedUser);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
	    UserDTO updatedUser = userService.patchUpdateUser(id, userDTO);
	    return ResponseEntity.ok(updatedUser);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
	    userService.deleteUserById(id);
	    return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
	}
}
