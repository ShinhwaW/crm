package cn.shinhwa.crm.service.impl;

import cn.shinhwa.crm.dao.UserDao;
import cn.shinhwa.crm.domain.User;
import cn.shinhwa.crm.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
