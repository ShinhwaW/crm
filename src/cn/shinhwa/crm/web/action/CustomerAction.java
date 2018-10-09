package cn.shinhwa.crm.web.action;

import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String saveUI() {
        return "saveUI";
    }


    public String save() {
        customerService.save(customer);
        return NONE;
    }
}
