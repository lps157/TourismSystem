package cn.travel.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public interface BaseDao<T> {
	// �������޸�
	void saveOrUpdate(T t);

	// ��
	void save(T t);

	// ɾ
	void delete(T t);

	// ɾ
	void delete(Serializable id);

	// ��
	void update(T t);

	// ��
	T getById(Serializable id);

	// �� �����������ܼ�¼��
	Integer getTotalCount(DetachedCriteria dc);

	// ��
	List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

	//������
	List<T> getAll(DetachedCriteria dc);
}
