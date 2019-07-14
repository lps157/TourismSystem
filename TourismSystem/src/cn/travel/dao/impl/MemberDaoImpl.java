package cn.travel.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.travel.dao.MemberDao;
import cn.travel.domain.Member;


//HibernateDaoSupport ÎªDao×¢ÈësessionFactory
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao {

	@Override
	public Member getByUserCode(final String username) {
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
		DetachedCriteria dc = DetachedCriteria.forClass(Member.class);

		dc.add(Restrictions.eq("username", username));
		List<Member> list = (List<Member>) getHibernateTemplate()
				.findByCriteria(dc);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
