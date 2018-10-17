package cn.shinhwa.crm.service.impl;

import cn.shinhwa.crm.dao.SaleVisitDao;
import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.domain.SaleVisit;
import cn.shinhwa.crm.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class SaleVisitServiceImpl implements SaleVisitService {
    private SaleVisitDao saleVisitDao;

    public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
        this.saleVisitDao = saleVisitDao;
    }

    @Override
    public PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<SaleVisit> pageBean = new PageBean<>();
        Integer totalCount = saleVisitDao.findCount(detachedCriteria);
        Double totalPage = Math.ceil(totalCount / pageSize);
        Integer begin = (currPage-1) * pageSize;
        if (currPage > totalPage) {
            pageBean.setCurrPage(totalPage.intValue());
        }else {
            pageBean.setCurrPage(currPage);
        }
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage.intValue());
        List<SaleVisit> list = saleVisitDao.findAll();
        pageBean.setList(list);
        return pageBean;
    }
}
