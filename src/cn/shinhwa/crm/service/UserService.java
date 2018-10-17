package cn.shinhwa.crm.service;

import cn.shinhwa.crm.domain.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    User login(User user);
}
