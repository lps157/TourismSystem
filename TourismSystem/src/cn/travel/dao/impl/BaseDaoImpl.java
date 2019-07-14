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

	private Class clazz;// ���ڽ��������ڷ�������

	public BaseDaoImpl() {
		// ��õ�ǰ���͵Ĵ��з������͵ĸ���
		ParameterizedType ptClass = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		// ��������ڷ�������
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	// hibernate�Զ�ʶ��˲ʱ״̬����Ϳ�����״̬������ת��Ϊ�ɳ�����״̬
	// ˲ʱ״̬:û��id��û����session����
	// ����״̬:��id��û����session����
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
		T t = this.getById(id);// ��ȡ��ɾ
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
		// ���ò�ѯ�ľۺϺ������ܼ�¼��
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate()
				.findByCriteria(dc);

		// ������õľۺϺ���
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
