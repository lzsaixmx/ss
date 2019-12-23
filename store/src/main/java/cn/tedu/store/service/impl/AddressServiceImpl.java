package cn.tedu.store.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.ex.AddressCountLimitException;
import cn.tedu.store.service.ex.InsertException;


/**
 * 处理收货地址数据的业务层实现类
 */
@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private IDistrictService districtService;
	@Value("${project.address.max-count}")
	private Integer maxCount;
	
	@Override
	public void addnew(Integer uid, String username, Address address) {
		// 调用addressMapper的countByUid()方法，根据参数uid查询该用户的收货地址数据的数量
		Integer count = addressMapper.countByUid(uid);
		// 判断数量是否达到上限
		if (count >= maxCount) {
			// 是：抛出AddressCountLimitException
			throw new AddressCountLimitException(
				"收货地址数据的数量不允许超过" + maxCount + "条");
		}

		// 补全数据：uid
		address.setUid(uid);
		// 补全数据：is_default(根据以上统计的数量判断得到)
		Integer isDefault = count == 0 ? 1 : 0;
		address.setIsDefault(isDefault);
		// 补全数据：省、市、区的名称
		String provinceName = districtService
				.getNameByCode(address.getProvinceCode());
		String cityName = districtService
				.getNameByCode(address.getCityCode());
		String areaName = districtService
				.getNameByCode(address.getAreaCode());
		address.setProvinceName(provinceName);
		address.setCityName(cityName);
		address.setAreaName(areaName);
		// 补全数据：4项日志
		Date now = new Date();
		address.setCreatedUser(username);
		address.setCreatedTime(now);
		address.setModifiedUser(username);
		address.setModifiedTime(now);
		// 调用addressMapper的insert()方法，插入收货地址数据，并获取返回的受影响行数
		Integer rows = addressMapper.insert(address);
		// 判断受影响的行数是否不为1
		if (rows != 1) {
			// 是：抛出InsertException
			throw new InsertException(
				"插入收货地址数据时出现未知错误，请联系系统管理员");
		}
	}

}









