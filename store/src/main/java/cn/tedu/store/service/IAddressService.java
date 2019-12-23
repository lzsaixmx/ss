package cn.tedu.store.service;

import cn.tedu.store.entity.Address;

/**
 * 处理收货地址数据的业务层接口
 */
public interface IAddressService {

	/**
	 * 增加收货地址数据
	 * @param uid 用户id
	 * @param username 用户名
	 * @param address 新的收货地址数据
	 */
	void addnew(Integer uid, String username, Address address);
	
}
