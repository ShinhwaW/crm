package cn.shinhwa.crm.dao;

import cn.shinhwa.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {
    void save(Customer customer);

    List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

    Integer findCount(DetachedCriteria detachedCriteria);
}
