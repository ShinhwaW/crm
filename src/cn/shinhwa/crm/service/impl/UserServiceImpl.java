package cn.shinhwa.crm.service.impl;

import cn.shinhwa.crm.dao.UserDao;
import cn.shinhwa.crm.domain.User;
import cn.shinhwa.crm.service.UserService;
import cn.shinhwa.crm.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        User loginUser = userDao.find(user);
        return loginUser;
    }
}
