package cn.travel.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.Topic;
import cn.travel.utils.PageBean;

public interface TopicService {

	void save(Topic ni);

	// ��ҳҵ�񷽷�
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	// ����id�������
	Topic getById(Long id);

	List<Topic> getAll(DetachedCriteria dc);
}
