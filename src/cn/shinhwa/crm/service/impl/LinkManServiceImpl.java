package cn.shinhwa.crm.service.impl;

import cn.shinhwa.crm.dao.LinkManDao;
import cn.shinhwa.crm.domain.LinkMan;
import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LinkManServiceImpl implements LinkManService {
    private LinkManDao linkManDao;

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    @Override
    public PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<LinkMan> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        Integer totalCount = linkManDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        Double tc = totalCount.doubleValue();
        Double number = tc / pageSize;
        Double totalPage = Math.ceil(number);
        pageBean.setTotalPage(totalPage.intValue());
        Integer begin = (currPage - 1) * pageSize;
        if (currPage > totalPage){
            pageBean.setCurrPage(totalPage.intValue());
        }else {
            pageBean.setCurrPage(currPage);
        }
        List<LinkMan> list = linkManDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(LinkMan linkMan) {
        linkManDao.save(linkMan);
    }

    @Override
    public LinkMan findById(Long lkm_id) {
        return (LinkMan) linkManDao.findById(lkm_id);
    }

    @Override
    public void update(LinkMan linkMan) {
        linkManDao.update(linkMan);
    }

    @Override
    public void delete(LinkMan linkMan) {
        linkManDao.delete(linkMan);
    }
}
