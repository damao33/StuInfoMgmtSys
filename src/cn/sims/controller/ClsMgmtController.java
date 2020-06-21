package cn.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clsMgmt")
public class ClsMgmtController {
	@RequestMapping("/")
	public ModelAndView toclsMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		return modelAndView;		
	}
}

