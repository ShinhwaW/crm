package cn.shinhwa.crm.dao.impl;

import cn.shinhwa.crm.dao.CustomerDao;
import cn.shinhwa.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);

        return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);

    }

    @Override
    public Integer findCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size()>0){
            return list.get(0).intValue();
        }
        return null;

    }

    @Override
    public Customer findByCustId(Long cust_id) {
        return this.getHibernateTemplate().get(Customer.class,cust_id);
    }

    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public void update(Customer customer) {

        this.getHibernateTemplate().update(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
        if (list.size()>0) {
            return list;
        }
        return null;
    }

}
