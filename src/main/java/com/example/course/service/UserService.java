package com.example.course.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.UserDTO;
import com.example.course.model.User;
import com.example.course.repository.TransactionRepository;
import com.example.course.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
    private UserRepository userRepository;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	public UserDTO convertToDTO(User user) {
	    System.out.println("Mapping user: " + user.getId() + " - " + user.getName());
	    return modelMapper.map(user, UserDTO.class);
	}

    
    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }


    @Autowired
    private TransactionRepository transactionRepository; // Add this if not already

    public User createOrUpdateUser(UserDTO userDTO) {
//        User user;
//        
//        if (userDTO.getId() != null) {
//            // Fetch existing user
//            user = userRepository.findById(userDTO.getId())
//                    .orElseThrow(() -> new RuntimeException("User not found with id: " + userDTO.getId()));
//            modelMapper.map(userDTO, user); // update basic user fields
//        } else {
//            // New user
//            user = modelMapper.map(userDTO, User.class);
//        }
//
//        // Handle transactions
//        List<Transaction> transactions = new ArrayList<>();
//
//        if (userDTO.getTransactions() != null) {
//            for (TransactionDTO tranDTO : userDTO.getTransactions()) {
//                Transaction transaction;
//
//                if (tranDTO.getId() != null) {
//                    // Update existing transaction
//                    transaction = transactionRepository.findById(tranDTO.getId())
//                            .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + tranDTO.getId()));
//                    modelMapper.map(tranDTO, transaction); // update fields
//                } else {
//                    // New transaction
//                    transaction = modelMapper.map(tranDTO, Transaction.class);
//                    transaction.setUser(user); // associate with user
//                }
//
//                transactions.add(transaction);
//            }
//        }
//
//        // Assign processed transactions to user (if bi-directional)
//        user.setTransactions(transactions);
    	
    	User user=convertToEntity(userDTO);
//    	if (user.getNotifications() != null) {
//            user.getNotifications().forEach(notification -> notification.setUser(user));
//        }
//
//        if (user.getSubscriptions() != null) {
//            user.getSubscriptions().forEach(subscription -> subscription.setUser(user));
//        }
//
//        if (user.getTransactions() != null) {
//            user.getTransactions().forEach(transaction -> transaction.setUser(user));
//        }
//
//        if (user.getChats() != null) {
//            user.getChats().forEach(chat -> chat.setUser(user));
//        }

        return userRepository.save(user);
    }
    
    public UserDTO patchUpdateUser(long id, UserDTO partialUserDTO) {
    	
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.typeMap(UserDTO.class, User.class)
        .addMappings(mapper -> mapper.skip(User::setChats))
        .addMappings(mapper -> mapper.skip(User::setNotifications))
        .addMappings(mapper -> mapper.skip(User::setSubscriptions))
        .addMappings(mapper -> mapper.skip(User::setTransactions));  // Ignore chats during mapping

        modelMapper.map(partialUserDTO, user);  // This will update only the non-null fields
        
        return convertToDTO(userRepository.save(user));
    }


    
    public List<UserDTO> getAllUsers() {
    	List<User> users = userRepository.findAll(); // Fetch all users
    	if (users == null || users.isEmpty()) {
            System.out.println("Users list is empty or null");
            return Collections.emptyList();
        }

        List<UserDTO> userDto = users.stream()
//            .peek(user -> System.out.println("Mapping user: " + user))
            .map(this::convertToDTO)
            .collect(Collectors.toList());

        System.out.println("Mapped DTOs: " + userDto);
        return userDto;

    }
    
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
    
    public UserDTO getUsersById(long id){
    	User user = null;
    	Optional<User> userOptional=userRepository.findById(id);
    	if(userOptional.isPresent()) {
    		user = userOptional.get();
    	}
    	return convertToDTO(user);
    }

	
}
