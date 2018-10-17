package cn.shinhwa.crm.web.action;

import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.domain.SaleVisit;
import cn.shinhwa.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

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

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
//        if (saleVisit.getCustomer().getCust_name() != null && !"".equals(saleVisit.getCustomer().getCust_name())) {
//            detachedCriteria.setProjection(Projections.sqlProjection("cust"))
//        }
        PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria,currPage,pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);

        return "findAll";
    }
}
