package cn.sims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.ClassMapper;

import cn.sims.model.Class;
import cn.sims.model.ClassExample;




@Controller
@RequestMapping("/clsMgmt")
public class ClsMgmtController {
	private SqlSession sqlSession;
	private ClassMapper classDao;
	List<Class> list;
	
	
	@RequestMapping("/")
	public ModelAndView toclsMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		MyBatisUtil.closeSqlSession();
		return modelAndView;		
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteClassByClno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		String clno = request.getParameter("clno");
		if(clno == null)clno="";
		int num=classDao.deleteByPrimaryKey(clno);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertClassByClno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		String clno = request.getParameter("clno");
		String clname = request.getParameter("clname");
		String htname  = request.getParameter("htname");
		String htno = request.getParameter("htno");
		if(clno == null)clno="";
		Class class1=new Class();
		class1.setClno(clno);
		class1.setClname(clname);
		class1.setHtno(htno);
		class1.setHtname(htname);
		int num = classDao.insert(class1);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateClassByExample(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		String clno = request.getParameter("clno");
		String clname = request.getParameter("clname");
		String htname  = request.getParameter("htname");
		String htno = request.getParameter("htno");
		if(clno == null)clno="";
		Class class1 = new Class();
		ClassExample se = new ClassExample();
		ClassExample.Criteria c = se.createCriteria();
		c.andClnoEqualTo(clno);
		class1.setClno(clno);
		class1.setClname(clname);
		class1.setHtno(htno);
		class1.setHtname(htname);
		int num = classDao.updateByExample(class1,se);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}