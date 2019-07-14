package cn.travel.dao;

import java.util.List;

import cn.travel.domain.Stype;

public interface StypeDao extends BaseDao<Stype> {
	List<Stype>  getAll();
}
