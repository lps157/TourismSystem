package cn.travel.dao;

import cn.travel.domain.User;

public interface UserDao extends BaseDao<User> {

	// �����û���½���Ʋ�ѯUser����
	User getByUserCode(String usercode);

}
