package cn.shinhwa.crm.dao;

import cn.shinhwa.crm.domain.User;

public interface UserDao {
    void save(User user);

    User find(User user);
}
