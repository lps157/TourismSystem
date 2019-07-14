package cn.travel.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.travel.dao.UserDao;
import cn.travel.domain.User;
import cn.travel.service.UserService;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

	private UserDao ud;

	@Override
	public User getUserByCodePassword(User u) {
		// 1.���ݵ�½���Ʋ�ѯ�û�
		User existU = ud.getByUserCode(u.getUser_code());
		// 2.�ж��û��Ƿ����,������=>�׳��쳣,��ʾ�û�������ȷ
		if (existU == null) {
			throw new RuntimeException("�û���������!");
		}
		// 3.�ж������Ƿ���ȷ,����ȷ=>�׳��쳣,��ʾ�������
		if (!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("�������!");
		}
		// 4.���ز�ѯ�����û�����
		return existU;
	}
	
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User u) {
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public List<User> list(DetachedCriteria dc) {
		List<User> list = ud.getAll(dc);
		return list;
	}

}
