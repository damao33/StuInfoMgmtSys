package cn.sims.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.dao.UserMapper;
import cn.sims.model.User;
import cn.sims.model.UserExample;
import cn.sims.util.MyBatisUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private SqlSession sqlSession;
	private UserMapper loginDao;
	
	@RequestMapping("/")
	public ModelAndView login(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		loginDao = sqlSession.getMapper(UserMapper.class);
		UserExample userExample = new UserExample();
		UserExample.Criteria c = userExample.createCriteria();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user = new User(account, password);
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
			modelAndView = new ModelAndView("loginfail");			
		}		
		return modelAndView;
	}
}
