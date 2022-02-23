package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);
        StringBuilder stringBuilder=new StringBuilder(userDto.getPassword());
        userEntity.setEncryptedPassword(stringBuilder.reverse().toString());
        userEntity=userRepository.save(userEntity);
        return modelMapper.map(userEntity,UserDto.class);
    }
    @Override
    public List<UserDto> getUsers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserDto> list=new ArrayList<>();
        Iterable<UserEntity> iterable= userRepository.findAll();
        Iterator<UserEntity> iterator= iterable.iterator();
        while (iterator.hasNext())
        {
            list.add(modelMapper.map(iterator.next(),UserDto.class));
        }
        return list;
    }

    @Override
    public UserDto findUserByUserId(String userId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity= userRepository.findByUserId(userId);
        if (userEntity==null)
        {
            throw new UserNotFoundException("User with id "+userId+ " is not found");
        }
        return modelMapper.map(userEntity,UserDto.class);
    }

    @Override
    public UserDto updateUserByUserId(String userId) {
        return null;
    }


}