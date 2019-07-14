package cn.travel.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.travel.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	// 不校验登陆和注册方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 1 获得Session
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 2 获得登陆标识
		User user = (User) session.get("admin");
		// 3 判断标识是否存在
		if (user != null) {
			// 存在=> 放行
			//System.out.println("放行");
			return invocation.invoke();

		} else {
			// 不存在=> 重定向到登陆页面
			//System.out.println("重新登录");
			return "toLogin";
		}

	}

}
