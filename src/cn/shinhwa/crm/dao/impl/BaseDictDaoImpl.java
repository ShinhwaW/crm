package cn.shinhwa.crm.dao.impl;

import cn.shinhwa.crm.dao.BaseDictDao;
import cn.shinhwa.crm.domain.BaseDict;

import java.util.List;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {


/*    public BaseDictDaoImpl() {
        super(BaseDict.class);
    }*/

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?",dict_type_code);
        if (list.size()>0){
            return list;
        }
        return null;
    }

}
