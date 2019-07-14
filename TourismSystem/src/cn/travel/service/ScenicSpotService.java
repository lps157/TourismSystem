package cn.travel.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.ScenicSpot;
import cn.travel.utils.PageBean;

public interface ScenicSpotService {

	void save(ScenicSpot s);

	// 分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	// 根据id获得客户
	ScenicSpot getById(Long scenic_id);
}
