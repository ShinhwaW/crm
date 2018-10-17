package cn.shinhwa.crm.service;

import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
    PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);
}
