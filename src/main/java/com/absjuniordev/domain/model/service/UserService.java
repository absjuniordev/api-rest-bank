package com.absjuniordev.domain.model.service;

import com.absjuniordev.domain.model.User;

public
interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
