package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.ui.UserRequestModel;
import com.example.userservice.ui.UserResponseModel;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<UserDto> getUsers();
    public UserDto findUserByUserId(String userId);
    public void deleteUserByUserId(String userId);
 UserDto updateUserByUserId(UserRequestModel userRequestModel, String userId);
    public void deleteUserByEmail(String email);
    public UserResponseModel updateUserByEmail(UserRequestModel userRequestModel, String email);
}
