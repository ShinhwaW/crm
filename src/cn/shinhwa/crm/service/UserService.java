package cn.shinhwa.crm.service;

import cn.shinhwa.crm.domain.User;

public interface UserService {
    void save(User user);

    User login(User user);
}
