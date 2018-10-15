package cn.shinhwa.crm.dao;

import cn.shinhwa.crm.domain.User;

public interface UserDao extends BaseDao<User> {

    User find(User user);
}
