package cn.shinhwa.crm.service.impl;

import cn.shinhwa.crm.dao.CustomerDao;
import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }
}
