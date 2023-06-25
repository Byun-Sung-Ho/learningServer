package com.example.libapp.service.user;

import com.example.libapp.DTO.response.UserResponse;
import com.example.libapp.DTO.user.request.UserCreateRequest;
import com.example.libapp.DTO.user.request.UserUpdateRequest;
import com.example.libapp.domain.User;
import com.example.libapp.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
    }
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserResponse(user.getId(), user.getName(), user.getAge())).collect(Collectors.toList());
    }
    @Transactional
    public void updateUser(UserUpdateRequest request){
        User user = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        user.updateName(request.getName());
        userRepository.save(user);
    }
    @Transactional
    public void deleteUser(String name){
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new IllegalArgumentException();
        }

        userRepository.delete(user);
    }
}
