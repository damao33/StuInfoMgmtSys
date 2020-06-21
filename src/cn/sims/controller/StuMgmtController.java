package cn.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stuMgmt")
public class StuMgmtController {
	@RequestMapping("/")
	public ModelAndView toStuMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		return modelAndView;		
	}
}

