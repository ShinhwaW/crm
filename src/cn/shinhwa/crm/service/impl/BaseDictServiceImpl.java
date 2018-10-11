package cn.shinhwa.crm.service.impl;

import cn.shinhwa.crm.dao.BaseDictDao;
import cn.shinhwa.crm.domain.BaseDict;
import cn.shinhwa.crm.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {
    private BaseDictDao baseDictDao;

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return baseDictDao.findByTypeCode(dict_type_code);
    }

    @Override
    public List<BaseDict> findAll() {
        return baseDictDao.findAll();
    }
}
