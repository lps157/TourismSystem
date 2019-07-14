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
		// 1.根据登陆名称查询用户
		User existU = ud.getByUserCode(u.getUser_code());
		// 2.判断用户是否存在,不存在=>抛出异常,提示用户名不正确
		if (existU == null) {
			throw new RuntimeException("用户名不存在!");
		}
		// 3.判断密码是否正确,不正确=>抛出异常,提示密码错误
		if (!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误!");
		}
		// 4.返回查询到的用户对象
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
