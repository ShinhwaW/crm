package cn.shinhwa.crm.dao.impl;

import cn.shinhwa.crm.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private Class clazz;
    /*
        通过构造函数传入泛型具体类型,但是要在子类传入实际类型参数入Customer.class....
     */
    /*
    public BaseDaoImpl(Class clazz) {
        this.clazz = clazz;
    }*/

    /*
        通过泛型反射获得实际类型参数
     */

    public BaseDaoImpl() {
        Class clazz = this.getClass(); //正在被调用的类的Class,如CustomerDaoImpl.class
        Type type = clazz.getGenericSuperclass();  //参数化类型,BaseDaoImpl<Customer>
        ParameterizedType pType = (ParameterizedType) type;
        // 通过参数化类型获得实际类型参数,得到一个实际参数类型的数组如Map<String,Integer>
        Type[] types = pType.getActualTypeArguments();
        this.clazz = (Class) types[0];
    }


    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);

        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);

    }

    @Override
    public Integer findCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public T findById(Long cust_id) {
        return (T) this.getHibernateTemplate().get(clazz, cust_id);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public List<T> findAll() {
        List<T> list = (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
        if (list.size() > 0) {
            return list;
        }
        return null;
    }
}
