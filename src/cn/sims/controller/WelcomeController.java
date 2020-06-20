package cn.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	@RequestMapping("/")
	public ModelAndView toWelcome()
	{
		ModelAndView modelAndView = new ModelAndView("welcome");
		return modelAndView;		
	}
}
