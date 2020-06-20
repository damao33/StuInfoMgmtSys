package cn.sims.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	@RequestMapping("/")
	public ModelAndView toWelcome(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("welcome");
		return modelAndView;		
	}
}
