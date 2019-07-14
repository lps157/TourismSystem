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
		// 1.调用Dao查询总记录数
		Integer totalCount = newsInfoDao.getTotalCount(dc);
		// 2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3.调用Dao查询分页列表数据
		List<NewsInfo> list = newsInfoDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 4.列表数据放入pageBean中，并返回
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


	public void setNewsInfoDao(NewsInfoDao newsInfoDao) {
		this.newsInfoDao = newsInfoDao;
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void save(NewsInfo ni) {
		// 1.维护cutomer与数据字典对象的关系，由于struts2参数封装，会将参数封装到数据字典的id属性
		// 那么我们无需手动维护关系

		// 2.调用Dao保存用户
		newsInfoDao.saveOrUpdate(ni);

	}

	@Override
	public NewsInfo getById(Long id) {
		NewsInfo newsInfo = newsInfoDao.getById(id);
		return newsInfo;
	}

}
