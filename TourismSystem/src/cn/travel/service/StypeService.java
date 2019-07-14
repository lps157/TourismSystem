package cn.travel.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.Stype;
import cn.travel.utils.PageBean;

public interface StypeService {

	//获取类型列表
	List<Stype> getAll(DetachedCriteria dc);
	
	// 分页业务方法
		PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
				Integer pageSize);
}
