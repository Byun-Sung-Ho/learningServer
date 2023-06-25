package com.example.libapp.service.user;

import com.example.libapp.DTO.response.UserResponse;
import com.example.libapp.DTO.user.request.UserCreateRequest;
import com.example.libapp.DTO.user.request.UserUpdateRequest;
import com.example.libapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository){
        this.userJdbcRepository = userJdbcRepository;
    }

    public void updateUser(UserUpdateRequest request){
        if (userJdbcRepository.isUserNotExist(request.getId())){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name){
        if (userJdbcRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.deleteUser(name);
    }

    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }
}
