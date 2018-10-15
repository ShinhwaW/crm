package cn.shinhwa.crm.dao.impl;

import cn.shinhwa.crm.dao.UserDao;
import cn.shinhwa.crm.domain.User;

import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    /*public UserDaoImpl() {
        super(User.class);
    }*/

    @Override
    public User find(User user) {
        List<User> userList = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ?",
                user.getUser_code(), user.getUser_password());
        if (userList.size()>0) {
            return userList.get(0);
        }
        return null;
    }
}
