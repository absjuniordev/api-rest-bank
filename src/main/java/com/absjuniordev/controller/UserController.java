package com.absjuniordev.controller;

import com.absjuniordev.domain.model.User;
import com.absjuniordev.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public
class UserController {

    private final
    UserService userService;

    public
    UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Gets all users in the database")
    @GetMapping
    public ResponseEntity<Iterable<User>> findAll(){
        return ResponseEntity.ok( userService.findAll());
    }

    @Operation(summary = "Find a user by ID")
    @GetMapping("/{id}")
    public
    ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Delete a user by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
    userService.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @Operation(summary = "ALERT! This action deltas all data from the database.")
    @DeleteMapping
    public ResponseEntity<User> deleteAll(){
        userService.deleteAll();
        return ResponseEntity.ok().build();

    }

    @Operation(summary = "Create a user")
    @PostMapping
    public
    ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
