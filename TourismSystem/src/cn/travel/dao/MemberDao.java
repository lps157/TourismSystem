package cn.travel.dao;

import cn.travel.domain.Member;

public interface MemberDao extends BaseDao<Member>  {

	Member getByUserCode(String username);

}
