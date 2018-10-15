package cn.shinhwa.crm.dao;

import cn.shinhwa.crm.domain.BaseDict;

import java.util.List;

public interface BaseDictDao extends BaseDao<BaseDict> {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
