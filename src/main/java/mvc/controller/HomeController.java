package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mvc.entity.User;
import mvc.service.UserService;

@Controller
public class HomeController {
	
	@RequestMapping ("/hello")
	public String hello()
	{
		return "hello";
	}
	
	//without jsp page ka run
	@ResponseBody
	@RequestMapping("/test")
	public String testing()
	{
		String zero="wlcome Kuldeep";
		return zero;
	}
	@RequestMapping("/kuldeep")
	public String kuldeep()
	{
		return "yara";
	}
	@RequestMapping("/shivam")
	public String shivam(Model model)
	{
		model.addAttribute("sms","walcome to shivam");
		return "shivam";
	}
	/*
	 * @RequestMapping("/signup") public ModelAndView signup(Model model) {
	 * ModelAndView mv=new ModelAndView(); mv.setViewName("signup"); return mv; }
	 * 
	 * @RequestMapping(path="signupprocess",method=RequestMethod.POST) public
	 * ModelAndView signupprocess(
	 * 
	 * @RequestParam("name") String name,
	 * 
	 * @RequestParam("email") String email,
	 * 
	 * @RequestParam("password") String password
	 * 
	 * ) { ModelAndView mv=new ModelAndView(); mv.addObject("name",name);
	 * mv.addObject("email",email); mv.addObject("password",password);
	 * mv.setViewName("result"); return mv; }
	 */
	
	@RequestMapping("/signup")
	public ModelAndView signup()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
	@Autowired
	private UserService userService;
	@RequestMapping(path="signupprocess",method=RequestMethod.POST)
	public ModelAndView signupprocess(@ModelAttribute User user)
	{
		
		ModelAndView mv=new ModelAndView();
		System.out.println(user.toString());
		int no;
		no=this.userService.createUser(user);
		String sms="Data has saved successdully ";
		mv.addObject("sms",sms);
		mv.setViewName("result");
		
		return mv;
	}
}
