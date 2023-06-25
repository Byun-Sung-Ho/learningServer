package com.example.libapp.controller.user;

import com.example.libapp.DTO.response.UserResponse;
import com.example.libapp.DTO.user.request.UserCreateRequest;
import com.example.libapp.DTO.user.request.UserUpdateRequest;
import com.example.libapp.service.user.UserServiceV1;
import com.example.libapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
//        users.add(new User(request.getName(), request.getAge()));
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
//        List<UserResponse> responses = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            responses.add(new UserResponse(i+1, users.get(i).getName(), users.get(i).getAge()));
//        }
//
//        return responses;
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

    @GetMapping("/user/error-test")
    public void errorTest(){
        throw new IllegalArgumentException();
    }
}
