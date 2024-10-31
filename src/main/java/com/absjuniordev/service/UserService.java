package com.absjuniordev.service;

import com.absjuniordev.domain.model.User;

public
interface UserService {

    Iterable<User> findAll();

    User findById(Long id);

    User create(User userToCreate);

    void deleteById(Long id);

    void deleteAll();



}
