package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping ("/hello")
	public String hello()
	{
		return "hello";
	}
	
	@RequestMapping ("/singUp")
	public String singUp()
	{
		return "singUp";
	}
}
