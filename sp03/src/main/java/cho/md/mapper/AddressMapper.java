package cho.md.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cho.md.domain.Address;

public interface AddressMapper {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);
}
