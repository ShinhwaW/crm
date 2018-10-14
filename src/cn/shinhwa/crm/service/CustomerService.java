package cn.shinhwa.crm.service;

import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    Customer findByCustId(Long cust_id);

    void delete(Customer customer);

    void update(Customer customer);

    List<Customer> findAll();
}
