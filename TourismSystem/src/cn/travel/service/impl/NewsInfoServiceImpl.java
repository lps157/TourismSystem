package cn.travel.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.travel.dao.NewsInfoDao;
import cn.travel.domain.NewsInfo;
import cn.travel.service.NewsInfoService;
import cn.travel.utils.PageBean;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class NewsInfoServiceImpl implements NewsInfoService {

	private NewsInfoDao newsInfoDao;

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1.����Dao��ѯ�ܼ�¼��
		Integer totalCount = newsInfoDao.getTotalCount(dc);
		// 2.����PageBean����
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3.����Dao��ѯ��ҳ�б�����
		List<NewsInfo> list = newsInfoDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 4.�б����ݷ���pageBean�У�������
		for (NewsInfo ni : list) {
			System.out.println(ni.getTitle()+ni.getAuthor()+ni.getCreate_date());
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


	public void setNewsInfoDao(NewsInfoDao newsInfoDao) {
		this.newsInfoDao = newsInfoDao;
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void save(NewsInfo ni) {
		// 1.ά��cutomer�������ֵ����Ĺ�ϵ������struts2������װ���Ὣ������װ�������ֵ��id����
		// ��ô���������ֶ�ά����ϵ

		// 2.����Dao�����û�
		newsInfoDao.saveOrUpdate(ni);

	}

	@Override
	public NewsInfo getById(Long id) {
		NewsInfo newsInfo = newsInfoDao.getById(id);
		return newsInfo;
	}

}
