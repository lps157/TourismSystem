package cn.travel.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.LinkMan;
import cn.travel.utils.PageBean;

public interface LinkManService {

	// ������ϵ��
	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	// ����id�����ϵ��
	LinkMan getById(Long cust_id);

}
