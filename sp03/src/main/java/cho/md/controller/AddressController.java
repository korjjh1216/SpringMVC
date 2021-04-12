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
		log.info("#name: " + address.getName() + ", addr: " + address.getAddr());
		for(MultipartFile file: files) {
			log.info("#ofname: " + file.getOriginalFilename());
			log.info("#fsize: " + file.getSize());
			
		}
		addressService.insertS(address);
		return "redirect:list.do";
	}
	@GetMapping("del.do")
	public String delete(long seq) {
		addressService.deleteS(seq);
		
		return "redirect:list.do";
	}
}



