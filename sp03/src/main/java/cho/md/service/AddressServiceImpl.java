package cho.md.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cho.md.domain.Address;
import cho.md.domain.AddressFile;
import cho.md.filesetting.Path;
import cho.md.mapper.AddressMapper;
import lombok.extern.java.Log;

@Log
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

//	@Override
//	public void insertS(Address address) {
//		//addressDao.insert(address);
//		addressMapper.insert(address);
//	}

	@Override
	public void deleteS(long seq) {
		//addressDao.delete(seq);
		addressMapper.delete(seq);
	}

	ArrayList<AddressFile> uploadedFileList;
	@Transactional
	@Override
	public ArrayList<AddressFile> insertS(Address address, ArrayList<MultipartFile> files) {
		//1. 주소록 데이터를  insert 
//		if(address.getSeq() <= 0) {
//			address.setSeq(1);
//		}
		addressMapper.insertSelectKey(address);
		log.info("#address.getSeq(): " + address.getSeq());
		
		//2. 파일들을 업로딩
		uploadedFileList = new ArrayList<AddressFile>();
		for(MultipartFile file: files) {
			String ofname = file.getOriginalFilename();
			if(ofname != null) ofname = ofname.trim();
			if(ofname.length() != 0) {
				AddressFile addressFile = saveStore(file);
				uploadedFileList.add(addressFile);
				if(addressFile != null) {
					//3. 파일 데이터들을 insert 
					addressFile.setSeq(address.getSeq());
					addressMapper.insertFile(addressFile);
				}
			}
		}
		
		return uploadedFileList;
	}
	private AddressFile saveStore(MultipartFile file) {
		String ofname = file.getOriginalFilename();
		int idx = ofname.lastIndexOf(".");
		String ofheader = ofname.substring(0, idx); 
		String ext = ofname.substring(idx); 
		long ms = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		sb.append(ofheader);
		sb.append("_");
		sb.append(ms);
		sb.append(ext);
		String saveFileName = sb.toString();
		
		long fsize = file.getSize();
		log.info("#ofname:" + ofname 
				+ ", saveFileName: " + saveFileName + ", fsize: "+fsize);
		
		boolean flag = writeFile(file, saveFileName);
		if(flag) {
			log.info("#파일 업로드 성공: " + saveFileName);
			return new AddressFile(-1L, ofname, saveFileName, fsize, -1L);
		}else {
			log.info("#파일 업로드 실패: " + saveFileName);
			return null;
		}
	}
	private boolean writeFile(MultipartFile file, String saveFileName) {
		File dir = new File(Path.FILE_STORE); //저장소 경로 객체 
		if(!dir.exists()) dir.mkdir();
		
		FileOutputStream fos = null;
		try {
			byte data[] = file.getBytes();
			fos = new FileOutputStream(Path.FILE_STORE +"/"+ saveFileName);
			fos.write(data);
			fos.flush();
			
			return true;
		}catch(IOException ie) {
			return false;
		}finally {
			try {
				if(fos != null) fos.close();
			}catch(IOException ie) {}
		}
	}
	@Override
	public void removeFiles() {
		for(AddressFile addressFile: uploadedFileList) {
			//log.info("#AddressServiceImpl removeFiles() addressFile: " + addressFile);
			File f = new File(Path.FILE_STORE, addressFile.getSfname());
			f.delete();
		}
	}

	@Override
	public void removeFiles(long seq) {
		List<AddressFile> listFiles = addressMapper.FileListForRemove(seq);
		for(AddressFile addressFile : listFiles) {
			File f = new File(Path.FILE_STORE,addressFile.getSfname());
			if(f.exists()) f.delete();
		}
	}
}

