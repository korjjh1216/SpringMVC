package cho.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cho.md.dao.AddressDao;
import cho.md.domain.Address;

public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao AddressDao;
	
	@Override
	public List<Address> listS() {
		// TODO Auto-generated method stub
		return AddressDao.list();
	}

	@Override
	public void insertS(Address address) {
		// TODO Auto-generated method stub
		AddressDao.insert(address);
		
	}

	@Override
	public void deleteS(long seq) {
		// TODO Auto-generated method stub
		AddressDao.delete(seq);
	}

}
