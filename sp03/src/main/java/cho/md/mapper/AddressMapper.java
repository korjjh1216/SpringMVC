package cho.md.mapper;

import java.util.ArrayList;
import java.util.List;


import cho.md.domain.Address;
import cho.md.domain.AddressFile;

public interface AddressMapper {
	List<Address> list();
	//void insert(Address address);
	
	void delete(long seq);
	List<AddressFile> FileListForRemove(long seq);
	
	void insertSelectKey(Address address);
	void insertFile(AddressFile addressFile);
	
}
