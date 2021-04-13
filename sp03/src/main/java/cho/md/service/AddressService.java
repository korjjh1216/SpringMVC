package cho.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cho.md.domain.Address;
import cho.md.domain.AddressFile;

public interface AddressService {
	List<Address> listS();
	//void insertS(Address address);
	
	void deleteS(long seq);
	void removeFiles(long seq);
	
	//업로드 할때 실패시 삭제하는부분이 있는거.
	ArrayList<AddressFile> insertS(Address address, ArrayList<MultipartFile> files);
	void removeFiles();
	
	
}
