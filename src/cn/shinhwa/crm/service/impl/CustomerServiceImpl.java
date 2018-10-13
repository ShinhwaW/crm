package cn.shinhwa.crm.service.impl;

import cn.shinhwa.crm.dao.CustomerDao;
import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<Customer> pageBean = new PageBean<Customer>();
        //封装当前页数
        pageBean.setCurrPage(currPage);
        //封装每页记录数
        pageBean.setPageSize(pageSize);
        //封装总记录数
        Integer totalCount = customerDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        //封装每页显示数据的集合
        Integer begin = (currPage - 1) * pageSize;
        if (currPage > num.intValue()) {
            pageBean.setCurrPage(num.intValue());
            begin = (num.intValue() -1) * pageSize;
        }
        List<Customer> list = customerDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public Customer findByCustId(Long cust_id) {
        return customerDao.findByCustId(cust_id);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }
}
