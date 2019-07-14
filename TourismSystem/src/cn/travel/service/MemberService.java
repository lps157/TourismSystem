package cn.travel.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.Member;

public interface MemberService {

	Member getMemberByCodePassword(Member member);

	List<Member> list(DetachedCriteria dc);

}
