package com.its.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.its.util.PageResults;


/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:32:56
 *
 * @版本：Xinoman Technologies CO.,LTD.
 * 
 * @说明：BaseDAO 定义DAO的通用操作 
 */
public interface BaseDao<T, ID extends Serializable> {

	public void save(T t);  
	
	public void saveOrUpdate(T t);    
  
    public T load(ID id);
    
    public T get(ID id);
    
    public void update(T t);
    
    public boolean contains(T t);
    
    public void delete(ID id);
    
    public boolean deleteById(ID id);
    
    public void delete(T t);
    
    public void deleteAll(Collection<T> entities);   
    
    public T getByHQL(String hqlString, Object[] args);    
    
    public T getBySQL(String sqlString, Object[] args);
    
    public void queryHql(String hqlString, Object[] args); 
    
    public void querySql(String sqlString, Object[] args); 
  
    public List<T> getListByHQL(String hql, Object[] args); 
    
    public List<T> getListBySQL(String sqlString, Object[] args);
    
    public PageResults<T> findPageByFetchedHql(String hql, String countHql, int pageNo, int pageSize, Object[] args);
    
    public Long countByHql(String hql, Object[] args);
    
    public void refresh(T t);
}
