package cn.travel.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.travel.dao.MemberDao;
import cn.travel.dao.UserDao;
import cn.travel.domain.Member;
import cn.travel.domain.User;
import cn.travel.service.MemberService;
import cn.travel.service.UserService;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class MemberServiceImpl implements MemberService {

	private MemberDao md;
	
	@Override
	public Member getMemberByCodePassword(Member m) {
		// 1.根据登陆名称查询用户
		Member existU = md.getByUserCode(m.getUsername());
		// 2.判断用户是否存在,不存在=>抛出异常,提示用户名不正确
		if (existU == null) {
			throw new RuntimeException("用户名不存在!");
		}
		System.out.println(existU.getUsername());
		// 3.判断密码是否正确,不正确=>抛出异常,提示密码错误
		if (!existU.getPassword().equals(m.getPassword())) {
			throw new RuntimeException("密码错误!");
		}
		// 4.返回查询到的用户对象
		return existU;
	}

	public void setMd(MemberDao md) {
		this.md = md;
	}

	@Override
	public List<Member> list(DetachedCriteria dc) {
		List<Member> list = md.getAll(dc);
		return list;
	}
	
}
