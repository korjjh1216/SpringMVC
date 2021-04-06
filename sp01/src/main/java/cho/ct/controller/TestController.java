package cho.ct.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cho.ct.domain.Human;
import lombok.extern.java.Log;


@Log
@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/")
	public void m01() {
		System.out.println("m01()");
		log.info("");
	}
	
	@RequestMapping("/base1")
	public void m02() {
		System.out.println("m02()- GetÎ∞©Ïãù, Post Î∞©Ïãù,,,");
	}
	
	@RequestMapping(value="/base2", method=RequestMethod.GET)
	public void m03() {
		System.out.println("m03()- GetÎ∞©Ïãù");
	}
	
	@RequestMapping(value="/base3", method= {RequestMethod.GET, RequestMethod.POST})
	public void m04() {
		System.out.println("m04()- GetÎ∞©Ïãù, Post Î∞©Ïãù");
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET )
	public String form() {
		return "sample/form";
	}
	
	@GetMapping("json1")
	public ResponseEntity<String> m12(){
		String msg = "{\"name\":ΩΩ±‚\",\"age\":24}"; //json
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		return new ResponseEntity<String>(msg,headers,HttpStatus.OK);
	}
	
	@GetMapping("json2")
	public @ResponseBody Human m13() {
		return new Human("¡¯øÌ",27);
	}
}
