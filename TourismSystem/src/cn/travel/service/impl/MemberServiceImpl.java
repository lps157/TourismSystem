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
		// 1.���ݵ�½���Ʋ�ѯ�û�
		Member existU = md.getByUserCode(m.getUsername());
		// 2.�ж��û��Ƿ����,������=>�׳��쳣,��ʾ�û�������ȷ
		if (existU == null) {
			throw new RuntimeException("�û���������!");
		}
		System.out.println(existU.getUsername());
		// 3.�ж������Ƿ���ȷ,����ȷ=>�׳��쳣,��ʾ�������
		if (!existU.getPassword().equals(m.getPassword())) {
			throw new RuntimeException("�������!");
		}
		// 4.���ز�ѯ�����û�����
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
