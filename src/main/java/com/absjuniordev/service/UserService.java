package com.absjuniordev.service;

import com.absjuniordev.domain.model.User;

public
interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
