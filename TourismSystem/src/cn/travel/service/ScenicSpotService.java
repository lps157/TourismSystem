package cn.travel.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.ScenicSpot;
import cn.travel.utils.PageBean;

public interface ScenicSpotService {

	void save(ScenicSpot s);

	// ��ҳҵ�񷽷�
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	// ����id��ÿͻ�
	ScenicSpot getById(Long scenic_id);
}
