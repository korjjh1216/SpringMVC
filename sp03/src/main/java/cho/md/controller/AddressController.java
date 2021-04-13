package cho.md.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;
import cho.md.domain.Address;
import cho.md.domain.AddressFile;
import cho.md.service.AddressService;

@Log
@Controller
@RequestMapping("/address/*")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	
	@GetMapping("list.do")
	public ModelAndView list() {
		List<Address> list = addressService.listS();
		
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("address/list"); //View
		mv.addObject("list", list); //Model 
		*/
		ModelAndView mv = new ModelAndView("address/list", "list", list);
		
		return mv;
	}
	@GetMapping("write.do")
	public String write() {
		return "address/write";
	}
	@PostMapping("write.do")
	public String write(Address address, @RequestParam ArrayList<MultipartFile> files) {
		log.info("#name: " + address.getName() + ", addr: " + address.getAddr()+", seq: " + address.getSeq());
		for(MultipartFile file: files) {
			log.info("#ofname: " + file.getOriginalFilename());
			log.info("#fsize: " + file.getSize());
		}
		ArrayList<AddressFile> uploadedFileList = null;
		try {
			uploadedFileList = addressService.insertS(address,files);
		} catch (Exception ex) {
			log.info("#AddressController write ex :" + ex);
			for(AddressFile addressFile: uploadedFileList) {
				log.info("#ArrayList<AddressFile> uploadedFileList =" + addressFile.getSfname());
			}
		}
		return "redirect:list.do";
	}
	@GetMapping("del.do")
	public String delete(long seq) {
		addressService.removeFiles(seq);  //업로드된 파일 제거
		addressService.deleteS(seq);  // db 데이터 제거 
		// 위 순서가 바껴 db부터 제거하면 업로드된 파일을 찾지 못하니 순서 주의!
		//seq에 해당하는 파일들을 select : select * from ARRESS_FILE where SEQ=#{seq} 
		
		return "redirect:list.do";
	}
}



