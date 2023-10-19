package com.group.libraryapp.controller.user;


import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.fruit.FruitService;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 service;
    private final FruitService fruitService;

    @Autowired
    public UserController(UserServiceV2 service, @Qualifier("appleService") FruitService fruitService) {
        this.service = service;
        this.fruitService = fruitService;
    }

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request){
        service.saveUser(request);
    }

    /*@GetMapping("/fruit")
    public Fruit fruit(){
        return new Fruit("바나나",2000);
    }*/

    @GetMapping("/user")
    public List<UserResponse> getUser(){
        return service.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        service.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        service.deleteUser(name);
    }

}
