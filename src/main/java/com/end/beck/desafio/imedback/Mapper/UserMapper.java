package com.end.beck.desafio.imedback.Mapper;

import org.modelmapper.ModelMapper;

import com.end.beck.desafio.imedback.Model.User;
import com.end.beck.desafio.imedback.Model.DTO.UserDTO;

public class UserMapper {
    
    private UserMapper() { }
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static final User convertToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }

    public static final UserDTO convertToDTO (User user){
        return modelMapper.map(user, UserDTO.class);
    }

}
