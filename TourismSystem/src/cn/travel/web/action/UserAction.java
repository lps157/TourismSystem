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
		// 1.调用service实现登陆逻辑
		User u = userService.getUserByCodePassword(user);
		// 2.将登陆的User对象放入session域中
		ActionContext.getContext().getSession().put("admin", u);
		// 3.重定向到项目中
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
