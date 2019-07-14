package cn.travel.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.Topic;
import cn.travel.utils.PageBean;

public interface TopicService {

	void save(Topic ni);

	// 分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	// 根据id获得新闻
	Topic getById(Long id);

	List<Topic> getAll(DetachedCriteria dc);
}
