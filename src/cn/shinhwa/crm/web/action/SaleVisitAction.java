package cn.shinhwa.crm.web.action;

import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.domain.SaleVisit;
import cn.shinhwa.crm.domain.User;
import cn.shinhwa.crm.service.CustomerService;
import cn.shinhwa.crm.service.SaleVisitService;
import cn.shinhwa.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

    private SaleVisit saleVisit = new SaleVisit();
    @Override
    public SaleVisit getModel() {
        return saleVisit;
    }
    private SaleVisitService saleVisitService;

    public void setSaleVisitService(SaleVisitService saleVisitService) {
        this.saleVisitService = saleVisitService;
    }

    private CustomerService customerService;

    private UserService userService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
        if (pageSize == null){
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    private Date visit_end_time;

    public Date getVisit_end_time() {
        return visit_end_time;
    }

    public void setVisit_end_time(Date visit_end_time) {
        this.visit_end_time = visit_end_time;
    }

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
        if (saleVisit.getVisit_time() != null) {
            detachedCriteria.add(Restrictions.ge("visit_time",saleVisit.getVisit_time()));
        }
        if (visit_end_time != null){
            detachedCriteria.add(Restrictions.le("visit_time",visit_end_time));
        }
        PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria,currPage,pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);

        return "findAll";
    }

    public String saveUI() {
        List<Customer> customerList = customerService.findAll();
        List<User> userList = userService.findAll();

        ActionContext.getContext().getValueStack().set("customerList",customerList);
        ActionContext.getContext().getValueStack().set("userList",userList);
        return "saveUI";
    }

    public String save() {
        saleVisitService.save(saleVisit);
        return "saveSuccess";
    }

}
