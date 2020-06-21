package cn.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cozMgmt")
public class CozMgmtController {
	@RequestMapping("/")
	public ModelAndView tocozMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		return modelAndView;		
	}
}

