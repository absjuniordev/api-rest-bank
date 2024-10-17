package com.absjuniordev.domain.repository;

import com.absjuniordev.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
