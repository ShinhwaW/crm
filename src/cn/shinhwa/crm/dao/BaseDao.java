package cn.shinhwa.crm.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface BaseDao<T> {

    void save(T t);

    List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

    Integer findCount(DetachedCriteria detachedCriteria);

    T findById(Long cust_id);

    void delete(T t);

    void update(T t);

    List<T> findAll();
}
