package cn.travel.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.travel.dao.NewsInfoDao;
import cn.travel.dao.TopicDao;
import cn.travel.domain.NewsInfo;
import cn.travel.domain.Topic;
import cn.travel.service.NewsInfoService;
import cn.travel.service.TopicService;
import cn.travel.utils.PageBean;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class TopicServiceImpl implements TopicService {

	private TopicDao topicDao;

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1.调用Dao查询总记录数
		Integer totalCount = topicDao.getTotalCount(dc);
		// 2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3.调用Dao查询分页列表数据
		List<Topic> list = topicDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 4.列表数据放入pageBean中，并返回
		for (Topic t : list) {
			System.out.println(t.getName());
		}
		pb.setList(list);
		return pb;
	}

	/*
	 * @Override
	 * 
	 * @Transactional(isolation = Isolation.REPEATABLE_READ, propagation =
	 * Propagation.REQUIRED, readOnly = false) public void save(Customer c) { //
	 * 1.维护cutomer与数据字典对象的关系，由于struts2参数封装，会将参数封装到数据字典的id属性 // 那么我们无需手动维护关系
	 * 
	 * // 2.调用Dao保存用户 cd.saveOrUpdate(c);
	 * 
	 * }
	 * 
	 * @Override public Customer getById(Long cust_id) { return
	 * cd.getById(cust_id);
	 * 
	 * }
	 */


	

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Topic t) {
		// 1.维护cutomer与数据字典对象的关系，由于struts2参数封装，会将参数封装到数据字典的id属性
		// 那么我们无需手动维护关系

		// 2.调用Dao保存用户
		topicDao.saveOrUpdate(t);

	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	@Override
	public Topic getById(Long id) {
		Topic topic = topicDao.getById(id);
		return topic;
	}

	@Override
	public List<Topic> getAll(DetachedCriteria dc) {
		List<Topic> list = topicDao.getAll(dc);
		return list;
	}

}
