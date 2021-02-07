package io.duke.demo.service;

import io.duke.demo.model.UserInfo;

public interface UserService {
    void save(UserInfo userInfo);
    UserInfo findByUsername(String username);
}
