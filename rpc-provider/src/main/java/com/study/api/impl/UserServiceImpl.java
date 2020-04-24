package com.study.api.impl;

import com.study.api.UserService;
import com.study.dto.UserDTO;

public class UserServiceImpl implements UserService {
    @Override
    public UserDTO addUser(UserDTO userDTO) {
        userDTO.setUserId("1001");
        return userDTO;
    }
}
