package cn.travel.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.travel.dao.ScenicSpotDao;
import cn.travel.domain.ScenicSpot;
import cn.travel.service.ScenicSpotService;
import cn.travel.utils.PageBean;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class ScenicSpotServiceServiceImpl implements ScenicSpotService {

	private ScenicSpotDao ssd;

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1.����Dao��ѯ�ܼ�¼��
		Integer totalCount = ssd.getTotalCount(dc);
		// 2.����PageBean����
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3.����Dao��ѯ��ҳ�б�����
		List<ScenicSpot> list = ssd.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 4.�б����ݷ���pageBean�У�������
		for (ScenicSpot s : list) {
		
			System.out.println(s.getLow_price() + s.getScenic_name() + s.getStype().getType());
		}
		pb.setList(list);
		return pb;
	}


	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void save(ScenicSpot ss) {
		
		ssd.saveOrUpdate(ss);

	}

	@Override
	public ScenicSpot getById(Long scenic_id) {
		ScenicSpot scenicSpot = ssd.getById(scenic_id);
		System.out.println(scenicSpot.getScenic_name());
		return scenicSpot;
	}


	public void setSsd(ScenicSpotDao ssd) {
		this.ssd = ssd;
	}
}
