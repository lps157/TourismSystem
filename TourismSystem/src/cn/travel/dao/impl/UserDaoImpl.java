package cn.travel.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.travel.dao.UserDao;
import cn.travel.domain.User;

//HibernateDaoSupport ΪDaoע��sessionFactory
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getByUserCode(final String usercode) {
		// HQL
		/*
		 * return getHibernateTemplate().execute(new HibernateCallback<User>() {
		 * 
		 * @Override
		 * 
		 * public User doInHibernate(Session session)
		 * 
		 * throws HibernateException {
		 * 
		 * String hql = "from User where user_code=?";
		 * 
		 * Query query = session.createQuery(hql);
		 * 
		 * query.setParameter(0, usercode);
		 * 
		 * User user = (User) query.uniqueResult();
		 * 
		 * return user; } });
		 */
		// Criteria
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);

		dc.add(Restrictions.eq("user_code", usercode));
		List<User> list = (List<User>) getHibernateTemplate()
				.findByCriteria(dc);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
