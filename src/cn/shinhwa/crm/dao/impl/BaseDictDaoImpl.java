package cn.shinhwa.crm.dao.impl;

import cn.shinhwa.crm.dao.BaseDictDao;
import cn.shinhwa.crm.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {


    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?",dict_type_code);
        if (list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public List<BaseDict> findAll() {
        List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict");
        if (list.size()>0){
            return list;
        }
        return null;
    }
}
