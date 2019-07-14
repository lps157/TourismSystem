package cn.travel.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.travel.dao.StypeDao;
import cn.travel.domain.Stype;
import cn.travel.domain.User;

public class StypeDaoImpl extends BaseDaoImpl<Stype> implements StypeDao {

	
	@Override
	public List<Stype> getAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(Stype.class);
		List<Stype> list =  (List<Stype>) getHibernateTemplate().findByCriteria(dc);
	
		return list;
	}

}
