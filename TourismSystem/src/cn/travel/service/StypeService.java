package cn.travel.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.Stype;
import cn.travel.utils.PageBean;

public interface StypeService {

	//��ȡ�����б�
	List<Stype> getAll(DetachedCriteria dc);
	
	// ��ҳҵ�񷽷�
		PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
				Integer pageSize);
}
