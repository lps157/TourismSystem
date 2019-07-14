package cn.travel.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.travel.dao.BaseDao;
import cn.travel.domain.Stype;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;// 用于接收运行期泛型类型

	public BaseDaoImpl() {
		// 获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		// 获得运行期泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	// hibernate自动识别瞬时状态对象和可游离状态对象将其转换为可持续化状态
	// 瞬时状态:没有id，没有与session关联
	// 游离状态:有id，没有与session关联
	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);// 先取再删
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// 设置查询的聚合函数，总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate()
				.findByCriteria(dc);

		// 清空设置的聚合函数
		dc.setProjection(null);

		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		} else {
			return null;
		}
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start,
			Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc,
				start, pageSize);
		return list;
	}
	@Override
	public List<T> getAll(DetachedCriteria dc) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}
}
