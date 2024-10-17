package com.absjuniordev.domain.model.service.impl;

import com.absjuniordev.domain.model.User;
import com.absjuniordev.domain.model.service.UserService;
import com.absjuniordev.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public
    User create(User userToCreate) {
        if ( userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()) ){
            throw  new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreate);
    }
}
