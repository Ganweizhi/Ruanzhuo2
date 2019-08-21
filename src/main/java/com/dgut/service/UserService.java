package com.dgut.service;

import com.dgut.model.UserModel;

import java.util.List;

public interface UserService {

    public List<UserModel> getUserInfo(UserModel userModel);
}
