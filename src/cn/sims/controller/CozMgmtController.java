package cn.sims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.ClassMapper;
import cn.sims.dao.CourseMapper;
import cn.sims.model.Class;
import cn.sims.model.Course;
import cn.sims.model.CourseExample;



@Controller
@RequestMapping("/cozMgmt")
public class CozMgmtController {
	private SqlSession sqlSession;
	private CourseMapper courseDao;
	List<Course> list;
	
	
	@RequestMapping("/")
	public ModelAndView tocozMgmt(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//查询第几页，每页4条记录
		
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		CourseExample se = new CourseExample();
		list = courseDao.selectByExample(se);
		PageInfo<Course> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("mapname", "/");//传回映射名
		modelAndView.addObject("courselist", page);//传回插件生成的页面信息PageInfo
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/cno")
	public ModelAndView selectCourseByCno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		if(cno == null)cno="";
		Course course = courseDao.selectByPrimaryKey(cno);
		ModelAndView modelAndView = new ModelAndView("alterCoz");
		modelAndView.addObject("course", course);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteCourseByCno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		if(cno == null||cno.equals(""))cno="";
		int num=courseDao.deleteByPrimaryKey(cno);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("controllerMsg", "删除了"+num+"条记录");
		PageHelper.startPage(1, 4);
		CourseExample se = new CourseExample();
		list = courseDao.selectByExample(se);
		PageInfo<Course> page = new PageInfo<>(list);
		modelAndView.addObject("courselist",page);
		modelAndView.addObject("mapname","/");
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
		modelAndView.addObject("controllerMsg", "增加了"+num+"条用户信息");

		PageHelper.startPage(1, 4);
		CourseExample se = new CourseExample();
		list = courseDao.selectByExample(se);
		PageInfo<Course> page = new PageInfo<>(list);
		modelAndView.addObject("courselist",page);
		modelAndView.addObject("mapname", "/insert");
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
		ModelAndView modelAndView = new ModelAndView("alterCoz");
		modelAndView.addObject("num", num);

		PageHelper.startPage(1, 4);
		CourseExample s = new CourseExample();
		list = courseDao.selectByExample(s);
		PageInfo<Course> page = new PageInfo<>(list);
		modelAndView.addObject("courselist",page);
		modelAndView.addObject("mapname","/update");		
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}