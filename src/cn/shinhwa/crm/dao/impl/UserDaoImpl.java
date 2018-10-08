package cn.shinhwa.crm.dao.impl;

import cn.shinhwa.crm.dao.UserDao;
import cn.shinhwa.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

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
