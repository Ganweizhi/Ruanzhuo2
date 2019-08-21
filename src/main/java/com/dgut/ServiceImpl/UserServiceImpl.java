package com.dgut.ServiceImpl;

import com.dgut.mapper.UserMapper;
import com.dgut.model.UserModel;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserModel> getUserInfo(UserModel user) {
        List<UserModel> users = userMapper.selectAll(null);
        return users;
    }
}