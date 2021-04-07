package cho.md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Controller

public class IndexController {
	@RequestMapping("/")
	public String m() {
		return "index";
	}
}
