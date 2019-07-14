package cn.travel.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.NewsInfo;
import cn.travel.utils.PageBean;

public interface NewsInfoService {
	void save(NewsInfo ni);

	// ��ҳҵ�񷽷�
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	// ����id�������
	NewsInfo getById(Long scenic_id);
}
