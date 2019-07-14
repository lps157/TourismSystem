package cn.travel.web.action;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.travel.domain.Member;
import cn.travel.service.MemberService;

public class MemberAction extends ActionSupport implements ModelDriven<Member> {
	private Member member = new Member();
	private MemberService ms;

	public void setMemberService(MemberService memberService) {
		this.ms = memberService;
	}

	public String login() throws Exception {
		// 1.调用service实现登陆逻辑
		Member m = ms.getMemberByCodePassword(member);
		// 2.将登陆的对象放入session域中
		ActionContext.getContext().getSession().put("member", m);
		// 3.重定向到项目中
		return "toIndex";
	}
	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Member.class);
		List<Member> list = ms.list(dc);
		for (Member user : list) {
			System.out.println(user.toString());
		}
		ActionContext.getContext().put("memberList", list);
		return "toList";
		
	}
	@Override
	public Member getModel() {
		return member;
	}

	public void setMs(MemberService ms) {
		this.ms = ms;
	}
	
	
}
