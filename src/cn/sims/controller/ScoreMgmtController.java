package cn.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/scoreMgmt")
public class ScoreMgmtController {
	@RequestMapping("/")
	public ModelAndView toscoreMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		return modelAndView;		
	}
}

