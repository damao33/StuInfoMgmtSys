package cn.sims.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.dao.SysuserMapper;
import cn.sims.model.Sysuser;
import cn.sims.model.SysuserExample;
import cn.sims.util.MyBatisUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private SqlSession sqlSession;
	private SysuserMapper loginDao;
	
	@RequestMapping("/")
	public ModelAndView login(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		loginDao = sqlSession.getMapper(SysuserMapper.class);
		SysuserExample userExample = new SysuserExample();
		SysuserExample.Criteria c = userExample.createCriteria();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Sysuser user = new Sysuser(account, password);
		System.out.println("account:"+account);
		System.out.println("pwd:"+password);
		c.andAccountEqualTo(account);
		c.andPasswordEqualTo(password);
		int loginStmt = loginDao.selectByExample(userExample).size();
		ModelAndView modelAndView;
		if(loginStmt == 1)
		{
			modelAndView = new ModelAndView("../index");
			modelAndView.addObject("user", user);
		}else
		{
			modelAndView = new ModelAndView("../login");
			modelAndView.addObject("loginMsg", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°");						
		}		
		return modelAndView;
	}
}
