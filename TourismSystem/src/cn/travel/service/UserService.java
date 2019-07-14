package cn.travel.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.User;

public interface UserService {

	// ��½
	User getUserByCodePassword(User u);

	// �����û�
	void saveUser(User u);

	List<User> list(DetachedCriteria dc);

}
