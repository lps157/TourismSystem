package cn.travel.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import cn.travel.dao.StypeDao;
import cn.travel.domain.ScenicSpot;
import cn.travel.domain.Stype;
import cn.travel.service.StypeService;
import cn.travel.utils.PageBean;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class StypeServiceImpl implements StypeService {

	private StypeDao sd;

	@Override
	public List<Stype> getAll(DetachedCriteria dc) {
		List<Stype> list = sd.getAll(dc);
		return list;
	}

	public void setSd(StypeDao sd) {
		this.sd = sd;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1.调用Dao查询总记录数
		Integer totalCount = sd.getTotalCount(dc);
		// 2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3.调用Dao查询分页列表数据
		List<Stype> list = sd.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 4.列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}

}
