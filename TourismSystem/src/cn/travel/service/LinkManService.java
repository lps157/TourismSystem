package cn.travel.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.LinkMan;
import cn.travel.utils.PageBean;

public interface LinkManService {

	// 保存联系人
	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	// 根据id获得联系人
	LinkMan getById(Long cust_id);

}
