package cho.md.service;

import java.io.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cho.md.filesetting.Path;
import lombok.extern.java.Log;

@Log
@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public String saveStore(MultipartFile file) {
		
		String ofname = file.getOriginalFilename();
		int idx = ofname.lastIndexOf(".");
		String ofheader =ofname.substring(0,idx); ///aaa
		String ext = ofname.substring(idx);  /// .txt
		long ms = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		sb.append(ofheader);
		sb.append("_");
		sb.append(ms);
		sb.append(ext);
		String saveFileName = sb.toString();
		
		long fsize = file.getSize();
		log.info("#ofname:" + ofname +", saveFileName: " + saveFileName + ", fsize: " + fsize );
		
		boolean flag =  writeFile(file,saveFileName);
		if(flag) {
			log.info("#파일 업로드 성공");
			//dao에서 ofname, saveFileName,fsize 정보를 넘기는 메소드를 호출
		}else {
			log.info("#파일 업로드 실패");
		}
		return "";
	}

	@Override
	public boolean writeFile(MultipartFile file, String saveFileName) {
		File dir = new File(Path.FILE_STORE); //저장소 경로 객체 생성
		if(!dir.exists()) dir.mkdirs(); //mkdir  mkdirs 차이
		
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
	public String download(String fname) {
		// TODO Auto-generated method stub
		return null;
	}

}
