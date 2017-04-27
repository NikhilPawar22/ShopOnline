package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = {"/","/homepage"}, method =RequestMethod.GET )
	public String init(Model model){
		model.addAttribute("message", "Please Enter Your Login Details");
		return "homepage";
		
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean")LoginBean loginBean)
	{
		if(loginBean!=null && loginBean.getUserName()!=null && loginBean.getPassWord()!=null)
		{
			if(loginBean.getUserName().equals("nikhil") && loginBean.getPassWord().equals("123"))
			{
				model.addAttribute("message","welcome"+loginBean.getUserName());
				return "success";
			}else
				model.addAttribute("error","Invalid Inputs");
				return "login";
		}else
			model.addAttribute("error","Please Enter Details");
		return "login";
			
		
	}
	
}
