package com.its.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.its.dao.BaseDao;
import com.its.util.PageResults;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:21:36
 *
 * @版本：Xinoman Technologies CO.,LTD.
 * 
 * @说明：BaseDaoImpl 定义DAO的通用操作实现 
 */
@Repository
public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T,ID> {
	
	private static final Log log = LogFactory.getLog(BaseDaoImpl.class);
	
	protected Class<T> entityClass;
	
	@Resource
	private SessionFactory sessionFactory;

	public BaseDaoImpl() {		
		
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {        
        if (entityClass==null) {  
        	entityClass=(Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);  
        } 
        log.info("DAO的真实实现类是：" + this.entityClass.getName()); 
        return entityClass;
    }	
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取当前工作的Session 
	 */
	protected Session getSession(){
		//需要开启事物，才能得到CurrentSession
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T t) {
		this.getSession().save(t);
	}
	
	@Override
	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(ID id) {
		return (T) this.getSession().load(getEntityClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(ID id) {
		T load = (T) this.getSession().get(getEntityClass(), id);
		return load;
	}
	
	@Override
	public void update(T t) {
		this.getSession().update(t);
	}
	
	@Override
	public boolean contains(T t) {
		return this.getSession().contains(t);
	}
	
	@Override
	public void delete(ID id) {
		this.getSession().delete(this.load(id));
	}
	
	@Override
	public boolean deleteById(ID id) {
		T t = get(id);
		if (t == null) {
			return false;
		}
		delete(t);
		return true;
	}
	
	@Override
    public void delete(T t) {
        this.getSession().delete(t);
    }
	
	@Override
    public void deleteAll(Collection<T> entities) {
        for(Object entity : entities) {
            this.getSession().delete(entity);
        }
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public T getByHQL(String hqlString, Object[] args) {
		Query query = this.getSession().createQuery(hqlString);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		//当确定返回的实例只有一个或者null时 用uniqueResult()方法  
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getBySQL(String sqlString, Object[] args) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		return (T) query.uniqueResult();
	}
	
	@Override
	public void queryHql(String hqlString, Object[] args) {
		Query query = this.getSession().createQuery(hqlString);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		query.executeUpdate();
	}

	@Override
	public void querySql(String sqlString, Object[] args) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		query.executeUpdate();
	}

	@Override
	public List<T> getListByHQL(String hql, Object[] args) {
		Query query = this.getSession().createQuery(hql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}		
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<T> getListBySQL(String sqlString, Object[] args) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (args != null)
        {
            for (int i = 0; i < args.length; i++)
            {
                query.setParameter(i, args[i]);
            }
        }
        return query.list();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public PageResults<T> findPageByFetchedHql(String hql, String countHql,int pageNo, int pageSize, Object[] args) {
        PageResults<T> pageResults = new PageResults<T>();
        Query query = this.getSession().createQuery(hql);
        if(args != null){
            for(int i = 0; i < args.length; i++) {
                query.setParameter(i, args[i]);
            }
        }
        int currentPage = pageNo > 1 ? pageNo : 1;
        pageResults.setCurrentPage(currentPage);
        pageResults.setPageSize(pageSize);
        if (countHql == null)
        {
            ScrollableResults results = query.scroll();
            results.last();
            pageResults.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
        }
        else
        {
            Long count = countByHql(countHql, args);
            pageResults.setTotalCount(count.intValue());
        }
        pageResults.resetPageNo();
        List<T> itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
        if (itemList == null)
        {
            itemList = new ArrayList<T>();
        }
        pageResults.setResults(itemList);
         
        return pageResults;
    }
	
	@Override
    public Long countByHql(String hql, Object[] args) {
        Query query = this.getSession().createQuery(hql);
        if(args != null){
            for(int i = 0; i < args.length; i++) {
                query.setParameter(i, args[i]);
            }
        }
        return (Long) query.uniqueResult();
    }
	
	@Override
	public void refresh(T t) {
		this.getSession().refresh(t);
	}
	
}
