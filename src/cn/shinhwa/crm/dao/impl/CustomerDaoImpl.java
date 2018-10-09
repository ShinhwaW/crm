package cn.shinhwa.crm.dao.impl;

import cn.shinhwa.crm.dao.CustomerDao;
import cn.shinhwa.crm.domain.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

}
