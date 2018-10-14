package cn.shinhwa.crm.web.action;

import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.domain.LinkMan;
import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.service.CustomerService;
import cn.shinhwa.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan = new LinkMan();

    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    private LinkManService linkManService;

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
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

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        if (linkMan.getLkm_name() != null) {
            detachedCriteria.add(Restrictions.like("lkm_name","%" + linkMan.getLkm_name() + "%"));
        }
        if (linkMan.getLkm_gender() != null && !"".equals(linkMan.getLkm_gender())) {
            detachedCriteria.add(Restrictions.eq("lkm_gender",linkMan.getLkm_gender()));
        }
        PageBean<LinkMan> pageBean = linkManService.findByPage(detachedCriteria,currPage,pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    public String saveUI() {
        List<Customer> list = customerService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "saveUI";
    }

    public String save() {
        linkManService.save(linkMan);
        return "saveSuccess";
    }

    public String editUI() {
        List<Customer> list = customerService.findAll();
        linkMan = linkManService.findById(linkMan.getLkm_id());
        ActionContext.getContext().getValueStack().set("list",list);
        ActionContext.getContext().getValueStack().push(linkMan);
        return "editUI";
    }

    public String edit() {
        linkManService.update(linkMan);
        return "editSuccess";
    }

    public String delete() {
        linkMan = linkManService.findById(linkMan.getLkm_id());
        linkManService.delete(linkMan);
        return "deleteSuccess";
    }


}
