package cn.tedu.store;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	DataSource dataSource;
	
	@Test
	public void getConnection() throws SQLException {
		System.err.println(dataSource.getConnection());
	}
	
//	@Test
//	public void md5() {
//		String password = "123456";
//		String salt = UUID.randomUUID().toString();
//		System.err.println(salt);
//		password = DigestUtils.md5DigestAsHex(
//				(salt + password + salt).getBytes());
//		System.err.println(password);
//		// 1234
//		// 81dc9bdb52d04dc20036dbd8313ed055
//		// 123456
//		// e10adc3949ba59abbe56e057f20f883e
//		// 1
//		// c4ca4238a0b923820dcc509a6f75849b
//		// 700+个1
//		// 72a140dae5131016a75a56d1d7c130cb
//	}
	
	@Test
	public void commonsCodec() {
		String password = "123456";
		// ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413
		password = DigestUtils.sha512Hex(password);
		System.err.println(password);
	}
	
	@Test
	public void uuid() {
		for (int i = 0; i < 10; i++) {
			String uuid = UUID.randomUUID().toString();
			System.err.println(uuid);
		}
	}
	

	public void a() throws IOException {
		throw new IOException();
	}
	
	public void service() throws IOException {
		a();
	}
	
	public void controller() {
		try {
			service();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}










