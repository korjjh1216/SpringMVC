package cho.md.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cho.md.domain.Address;
import cho.md.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping("list.do")
	public ModelAndView list() {
		List<Address> list =addressService.listS();
		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("address/list"); // view
//		mv.addObject("list",list); //model
		
		ModelAndView mv = new ModelAndView("address/list", "list", list);
		
		return mv;
	}
	//폼으로 이동
	@GetMapping("/write.do")
	public String write() {
		return "address/write";
	}
	//데이터베이스를 집어넣는거다.
	@PostMapping("/write.do")
	public String writeOk(Address address) {
		addressService.insertS(address);
		
		return "redirect:list.do";
	}
	
	@GetMapping("del.do")
	public String delete(long seq) {
		addressService.deleteS(seq);
		return "redirect:list.do";
	}
}
