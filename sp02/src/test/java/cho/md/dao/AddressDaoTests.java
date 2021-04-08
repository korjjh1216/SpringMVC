package cho.md.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;
import cho.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressDaoTests {
	@Autowired
	private AddressDao addressDao;
    /*
	@Test
	public void testList() {
		log.info("#addressDaoTests addressDao: " + addressDao);
		log.info("#addressDaoTests testList(): " + addressDao.list());
	}*/
	/*
	@Test
	public void testInsert() {
		Address address = new Address(-1, "오늘은", "목요일",  null);
		addressDao.insert(address);
		log.info("#addressDaoTests insert() 수행 완료");
	}*/
	@Test
	public void testDelete() {
		long seq = 17L;
		addressDao.delete(seq);
		log.info("#addressDaoTests delete() 수행 완료");
	}
}
