package cn.travel.service;

import java.util.List;

import cn.travel.domain.BaseDict;

public interface BaseDictService {

	// ���������ֵ������ֶλ�������ֵ����
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
