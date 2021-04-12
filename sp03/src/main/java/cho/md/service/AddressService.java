package cho.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cho.md.domain.Address;

public interface AddressService {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
}
