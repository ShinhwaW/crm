package cn.shinhwa.crm.service;

import cn.shinhwa.crm.domain.LinkMan;
import cn.shinhwa.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {
    PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    void save(LinkMan linkMan);

    LinkMan findById(Long lkm_id);

    void update(LinkMan linkMan);

    void delete(LinkMan linkMan);
}
