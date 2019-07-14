package cn.travel.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.NewsInfo;
import cn.travel.utils.PageBean;

public interface NewsInfoService {
	void save(NewsInfo ni);

	// 分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	// 根据id获得新闻
	NewsInfo getById(Long scenic_id);
}
