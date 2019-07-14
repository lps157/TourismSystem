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
		// 1.����Dao��ѯ�ܼ�¼��
		Integer totalCount = topicDao.getTotalCount(dc);
		// 2.����PageBean����
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3.����Dao��ѯ��ҳ�б�����
		List<Topic> list = topicDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 4.�б����ݷ���pageBean�У�������
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
	 * 1.ά��cutomer�������ֵ����Ĺ�ϵ������struts2������װ���Ὣ������װ�������ֵ��id���� // ��ô���������ֶ�ά����ϵ
	 * 
	 * // 2.����Dao�����û� cd.saveOrUpdate(c);
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
		// 1.ά��cutomer�������ֵ����Ĺ�ϵ������struts2������װ���Ὣ������װ�������ֵ��id����
		// ��ô���������ֶ�ά����ϵ

		// 2.����Dao�����û�
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
