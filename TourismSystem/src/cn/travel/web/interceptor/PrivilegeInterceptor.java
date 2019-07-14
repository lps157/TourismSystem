package cn.travel.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.travel.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	// ��У���½��ע�᷽��
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 1 ���Session
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 2 ��õ�½��ʶ
		User user = (User) session.get("admin");
		// 3 �жϱ�ʶ�Ƿ����
		if (user != null) {
			// ����=> ����
			//System.out.println("����");
			return invocation.invoke();

		} else {
			// ������=> �ض��򵽵�½ҳ��
			//System.out.println("���µ�¼");
			return "toLogin";
		}

	}

}
