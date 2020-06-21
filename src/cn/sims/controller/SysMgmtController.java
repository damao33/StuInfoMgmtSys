package cn.sims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.UserMapper;
import cn.sims.model.User;
import cn.sims.model.UserExample;

@Controller
@RequestMapping("/sysMgmt")
public class SysMgmtController {
	private SqlSession sqlSession;
	private UserMapper userDao;
	List<User> list;
	
	@RequestMapping("/")
	public ModelAndView tosysMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		return modelAndView;		
	}
	@RequestMapping("/all")
	public ModelAndView selectAllUsers()
	{
		sqlSession = MyBatisUtil.getSqlSession();
		userDao = sqlSession.getMapper(UserMapper.class);
		UserExample se = new UserExample();
		list = userDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("userlist", list);
		return modelAndView;
	}
	@RequestMapping("/account")
	public ModelAndView selectStudentByClass(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		userDao = sqlSession.getMapper(UserMapper.class);
		String account = request.getParameter("account");
		if(account == null)account="";
		
		User user = userDao.selectByPrimaryKey(account);
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteUserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		userDao = sqlSession.getMapper(UserMapper.class);
		String account = request.getParameter("account");
		if(account == null)account="";
		int num=userDao.deleteByPrimaryKey(account);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("num", num);
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertUserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		userDao = sqlSession.getMapper(UserMapper.class);
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account == null)account="";
		User user = new User(account,password);
		int num = userDao.insert(user);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("num", num);
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateUserByExample(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		userDao = sqlSession.getMapper(UserMapper.class);
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account == null)account="";
		User user = new User(account,password);
		UserExample se = new UserExample();
		UserExample.Criteria c = se.createCriteria();
		c.andAccountEqualTo(account);
		int num = userDao.updateByExample(user,se);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("num", num);
		return modelAndView;
	}
	
}
