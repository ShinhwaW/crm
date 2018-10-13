package cn.shinhwa.crm.web.action;

import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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

    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        if (currPage == null) {
            currPage = 1;
        }
        this.currPage = currPage;
    }

    private Integer pageSize = 3;

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    public String saveUI() {
        return "saveUI";
    }


    public String save() {
        customerService.save(customer);
        return SUCCESS;
    }

    public String findAll() {
        //接收参数:分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
            detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }
        if (customer.getBaseDictSource() != null) {
            if (customer.getBaseDictSource().getDict_id() != null && !"".equals(customer.getBaseDictSource().getDict_id())) {
                detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id",
                        customer.getBaseDictSource().getDict_id()));
            }
        }
        if (customer.getBaseDictLevel() != null) {
            if (customer.getBaseDictLevel().getDict_id() != null && !"".equals(customer.getBaseDictLevel().getDict_id())) {
                detachedCriteria.add(Restrictions.eq("getBaseDictLevel.dict_id",
                        customer.getBaseDictLevel().getDict_id()));
            }
        }
        if (customer.getBaseDictIndustry() != null) {
            if (customer.getBaseDictIndustry().getDict_id() != null && !"".equals(customer.getBaseDictIndustry().getDict_id())) {
                detachedCriteria.add(Restrictions.eq("getBaseDictIndustry.dict_id",
                        customer.getBaseDictIndustry().getDict_id()));
            }
        }

        PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria,currPage,pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);

        return "findAll";
    }
}
