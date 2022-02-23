package com.example.userservice.service;

import com.example.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<UserDto> getUsers();
    public UserDto findUserByUserId(String userId);
    public UserDto updateUserByUserId(String userId);
}
