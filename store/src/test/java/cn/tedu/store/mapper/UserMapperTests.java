package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("mybatis");
		user.setPassword("1234");
		
		System.err.println(user); // id=null
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
		System.err.println(user); // id=?
	}
	
	@Test
	public void updateAvatarByUid() {
		Integer uid = 19;
		String avatar = "AAA";
		String modifiedUser = "超级管理员";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updatePasswordByUid() {
		Integer uid = 15;
		String password = "AAA";
		String modifiedUser = "超级管理员";
		Date modifiedTime = new Date();
		Integer rows = mapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateInfoByUid() {
		User user = new User();
		user.setUid(18);
		user.setPhone("13999139999");
		// user.setEmail("root@sina.com.cn");
		user.setGender(1);
		user.setModifiedUser("测试管理员");
		user.setModifiedTime(new Date());
		Integer rows = mapper.updateInfoByUid(user);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 14;
		User result = mapper.findByUid(uid);
		System.err.println(result);
	}
	
	@Test
	public void findByUsername() {
		String username = "controller";
		User result = mapper.findByUsername(username);
		System.err.println(result);
	}

}






