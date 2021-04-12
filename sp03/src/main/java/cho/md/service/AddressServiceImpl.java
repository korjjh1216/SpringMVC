package cho.md.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cho.md.domain.Address;
import cho.md.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper addressMapper;
	//private AddressDao addressDao;
	
	@Override
	public List<Address> listS() {
		//return addressDao.list();
		return addressMapper.list();
	}

	@Override
	public void insertS(Address address) {
		//addressDao.insert(address);
		addressMapper.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		//addressDao.delete(seq);
		addressMapper.delete(seq);
	}


}
