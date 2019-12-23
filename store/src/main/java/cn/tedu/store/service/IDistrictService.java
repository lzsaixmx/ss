package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;

/**
 * 处理省/市/区数据的业务层接口
 */
public interface IDistrictService {
	
	/**
	 * 根据省/市/区的代号获取对应的名称
	 * @param code 省/市/区的代号
	 * @return 省/市/区的名称，如果没有匹配的数据，则返回null
	 */
	String getNameByCode(String code);

	/**
	 * 获取全国所有的省/某省所有的市/某市所有的区的数据列表
	 * @param parent 父级单位的行政代号，如果获取全国所有的省，则使用"86"
	 * @return 全国所有的省/某省所有的市/某市所有的区的数据列表
	 */
	List<District> getByParent(String parent);
	
}
