package cn.travel.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.travel.domain.User;

public interface UserService {

	// µÇÂ½
	User getUserByCodePassword(User u);

	// ±£´æÓÃ»§
	void saveUser(User u);

	List<User> list(DetachedCriteria dc);

}
