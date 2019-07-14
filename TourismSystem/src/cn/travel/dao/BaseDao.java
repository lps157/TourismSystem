package cn.travel.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public interface BaseDao<T> {
	// 增或者修改
	void saveOrUpdate(T t);

	// 增
	void save(T t);

	// 删
	void delete(T t);

	// 删
	void delete(Serializable id);

	// 改
	void update(T t);

	// 查
	T getById(Serializable id);

	// 查 符合条件的总记录数
	Integer getTotalCount(DetachedCriteria dc);

	// 查
	List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

	//查所有
	List<T> getAll(DetachedCriteria dc);
}
