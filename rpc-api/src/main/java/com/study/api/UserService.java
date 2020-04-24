package com.study.api;

import com.study.dto.UserDTO;


//TODO 其实这里的注解相当于dubbo中配置的接口和实现类
@ServiceMapped("com.study.api.impl.UserServiceImpl")
public interface UserService {

    public UserDTO  addUser(UserDTO  userDTO);


}
