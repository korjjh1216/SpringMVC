package cho.md.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cho.md.domain.Human;
import cho.md.domain.HumanList;
import lombok.extern.java.Log;


@Log
@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/")
	public void m01() {
		System.out.println("m01()");
	}
	@RequestMapping("/base1")
	public void m02() {
		System.out.println("m02() - Get방식, Post방식,..");
	}
	//@RequestMapping(value="/base2", method=RequestMethod.GET)
	@GetMapping("/base2")
	public void m03() {
		System.out.println("m03() - only Get방식");
	}
	@RequestMapping(value="/base3", method= {RequestMethod.GET, RequestMethod.POST})
	public void m04() {
		System.out.println("m04() - Get방식, Post방식");
	}
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(){
		return "test/form"; 
	}
	
	@RequestMapping("/param1")
	public void m05(@RequestParam String name, @RequestParam int age) {
		log.info("m05() name: " + name + ", age: " + age);
	}
	@RequestMapping("/param2")
	public void m06(Human dto) {
		log.info("m06() name: " + dto.getName() + ", age: " + dto.getAge());
	}
	@RequestMapping("/param3")
	public void m07(@RequestParam ArrayList<String> names) {	
		log.info("m07() names :" + names);
		//for(String name: names) log.info("m07() name: " + name);
	}
	@RequestMapping("/param4")
	public void m08(@RequestParam("ns") ArrayList<String> names) {	
		log.info("m08() names :" + names);
	}
	@RequestMapping("/param5")
	public void m09(@RequestParam String[] names) {	
		for(String name: names) log.info("m09() name: " + name);
	}
	
	@RequestMapping("/param6")
	public void m10(HumanList list) {
		//log.info("m10() list :" + list);
		ArrayList<Human> li = list.getList();
		for(Human man : li) {
			log.info("#name: " + man.getName());
			log.info("#age: " + man.getAge());
		}
	}
	@RequestMapping("/param7")
	public void m11(Human dto, int page) {
		log.info("m11() name: " + dto.getName() + ", age: " + dto.getAge() + ", page: " + page);
	}
	
	@GetMapping("json1")
	public ResponseEntity<String> m12(){
		String msg = "{\"name\":\"슬기\", \"age\":24}"; //JSON 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
	}
	
	@GetMapping("json2")
	public @ResponseBody Human m13() {
		return new Human("진욱", 27);
	}
	
	@GetMapping("txt")
	public @ResponseBody String m14() {
		return "Hello text^^";
	}
}

