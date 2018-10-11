package cn.shinhwa.crm.service;

import cn.shinhwa.crm.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> findByTypeCode(String dict_type_code);

    List<BaseDict> findAll();
}
