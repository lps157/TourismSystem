package cn.travel.dao;

import cn.travel.domain.User;

public interface UserDao extends BaseDao<User> {

	// 根据用户登陆名称查询User对象
	User getByUserCode(String usercode);

}
