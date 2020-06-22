package cn.sims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.CourseMapper;
import cn.sims.model.Course;
import cn.sims.model.CourseExample;



@Controller
@RequestMapping("/cozMgmt")
public class CozMgmtController {
	private SqlSession sqlSession;
	private CourseMapper courseDao;
	List<Course> list;
	
	
	@RequestMapping("/")
	public ModelAndView tocozMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		MyBatisUtil.closeSqlSession();
		return modelAndView;		
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteCourseByCno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		if(cno == null)cno="";
		int num=courseDao.deleteByPrimaryKey(cno);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertCourseByCno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String tno = request.getParameter("tno");
		String tname = request.getParameter("tname");
		if(cno == null)cno="";
		Course course=new Course();
		course.setCno(cno);
		course.setCname(cname);
		course.setTno(tno);
		course.setTname(tname);
		int num = courseDao.insert(course);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateCourseByExample(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String tno = request.getParameter("tno");
		String tname = request.getParameter("tname");
		if(cno == null)cno="";
		Course course = new Course();
		CourseExample se = new CourseExample();
		CourseExample.Criteria c = se.createCriteria();
		c.andCnoEqualTo(cno);
		course.setCno(cno);
		course.setCname(cname);
		course.setTno(tno);
		course.setTname(tname);
		int num = courseDao.updateByExample(course,se);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}