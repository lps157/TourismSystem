package cn.travel.web.action;


import cn.travel.domain.Stype;
import cn.travel.domain.User;
import cn.travel.service.UserService;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		// 1.����serviceʵ�ֵ�½�߼�
		User u = userService.getUserByCodePassword(user);
		// 2.����½��User�������session����
		ActionContext.getContext().getSession().put("admin", u);
		// 3.�ض�����Ŀ��
		return "toHome";
	}
	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		List<User> list = userService.list(dc);
		for (User user : list) {
			System.out.println(user.toString());
		}
		//ActionContext.getContext().getSession().put("userList", list);
		ActionContext.getContext().put("userList", list);
		return "toList";
		
	}
	@Override
	public User getModel() {
		return user;
	}
}
