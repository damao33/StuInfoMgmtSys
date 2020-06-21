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
}
