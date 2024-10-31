package com.absjuniordev.service.impl;

import com.absjuniordev.domain.model.User;
import com.absjuniordev.service.UserService;
import com.absjuniordev.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public
class UserServiceImpl implements UserService {


   private final
    UserRepository userRepository;

    public
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public
    Iterable<User> findAll() {
//        if(userRepository.findAll().isEmpty()){
//            throw new NoSuchElementException("The list is empty");
//        }
        return userRepository.findAll();
    }

    @Override
    public
    User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource ID not found."));
    }

    @Override
    public
    User create(User userToCreate) {
        if ( userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()) ){
            throw  new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public
    void deleteById(Long id) {
        if (!userRepository.existsById(id)){
            throw new IllegalArgumentException("This ID not exists");
        }
        userRepository.deleteById(id);
    }

    @Override
    public
    void deleteAll() {
        if (userRepository.findAll().isEmpty()){
            throw new NoSuchElementException("The list is empty");
        }
         userRepository.deleteAll();
    }


}
