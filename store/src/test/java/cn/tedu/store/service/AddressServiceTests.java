package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
	
	@Autowired
	private IAddressService service;
	
	@Test
	public void addnew() {
		try {
			Integer uid = 1;
			String username = "店老板";
			Address address = new Address();
			address.setName("食客");
			service.addnew(uid, username, address);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}

}







