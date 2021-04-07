package cho.md.controller;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cho.md.domain.Address;
import cho.md.mapper.AddressMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressMapperTests {
	@Autowired
	private AddressMapper addressMapper;
	
//	@Test
//	public void testList() {
//		log.info("AddressMapperTests addressMapper:" + addressMapper);
//		log.info("AddressMapperTests testList()" + addressMapper.list());
//	}
//	@Test
//	public void testList() {
//		Address address = new Address(-1,"힘든","셋팅",null);
//		addressMapper.insert(address);
//		log.info("##insert() 수행완료");
//	}
	@Test
	public void testDelete() {
		long seq = 12L;
		addressMapper.delete(seq);
		log.info("##delete() 수행완료");
	}
}
